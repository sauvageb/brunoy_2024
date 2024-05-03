package fr.cat.tcc.demo.batch.chunck;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import fr.cat.tcc.demo.batch.CustomerReaderDto;

public class CustomerBatchReader implements ItemReader<CustomerReaderDto>, StepExecutionListener {

	private CSVReader csvReader;
	private FileReader fileReader;

	@Override
	public void beforeStep(StepExecution stepExecution) {

		JobParameters jobParameters = stepExecution.getJobParameters();
		String csvFileName = jobParameters.getString("fileName");

		try {
			// Récupération du chemin du fichier CSV dans le context du projet
			ClassLoader classLoader = this.getClass().getClassLoader();
			if (fileReader == null) {
				URL url = classLoader.getResource(csvFileName);
				if (url == null)
					throw new FileNotFoundException("fichier url null");
				String loadedFilename = classLoader.getResource(csvFileName).getFile();
				// Initialise le lecteur du fichier
				fileReader = new FileReader(loadedFilename);
			}
			// Initialise le lecteur du CSV (basé sur openCSV)
			csvReader = new CSVReader(fileReader);
		} catch (FileNotFoundException e) {
			System.err.println("Fichier introuvable");
		}
	}

	@Override
	public CustomerReaderDto read() {
		try {
			// Lecture d'une ligne
			String[] currentLine = csvReader.readNext();
			if (currentLine != null) {
				CustomerReaderDto dto = new CustomerReaderDto();
				dto.setName(currentLine[0]);
				dto.setStatus(currentLine[1]);
				dto.setEmail(currentLine[2]);
				dto.setPhone(currentLine[3]);
				dto.setIban(currentLine[4]);
				dto.setBic(currentLine[5]);
				dto.setAddress(currentLine[6]);
				dto.setComplement(currentLine[7]);
				dto.setZipcode(currentLine[8]);
				dto.setCity(currentLine[9]);
				dto.setCountry(currentLine[10]);
				dto.setIntracommunityTVA(currentLine[11]);
				dto.setBusinessIdentification(currentLine[12]);
				return dto;
			}
		} catch (CsvValidationException e) {
			System.err.println("Ligne CSV Invalide");
		} catch (IOException e) {
			System.err.println("I/O Exception");
		}
		// Si la ligne est vide, on retourne null
		return null;
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		System.out.println("Reader COMPLETED");
		// Fermeture du lecteur de CSV pour éviter les fuite mémoires
		try {
			if (csvReader != null) {
				csvReader.close();
			}
		} catch (IOException e) {
			System.err.println("Fermeture CSV Reader impossible");
		}
		return ExitStatus.COMPLETED;
	}

}
