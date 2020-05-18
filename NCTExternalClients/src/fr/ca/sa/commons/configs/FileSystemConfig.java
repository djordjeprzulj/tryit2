package fr.ca.sa.commons.configs;

import org.jboss.logging.Logger;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class FileSystemConfig {

	private static final Logger LOGGER = Logger.getLogger(FileSystemConfig.class);

	private static final String NCT_ENVIRONMENT_VARIABLE = "NCT_HOME";

	private static final String DEFAULT_WINDOWS_NCT_DIR = "C:\\NCT";
	private static final String DEFAULT_LINUX_NCT_DIR = "/home/nct/NCT";
	private String nctRuntimeDirectory;

	/**
	 * File System Configuration
	 */
	public FileSystemConfig() {
		String nctHomeDir = System.getenv().get(NCT_ENVIRONMENT_VARIABLE);
		LOGGER.info("NCT ENV VAR: "+ nctHomeDir);
		// If no ENV variable is defined, use predefined location
		if (nctHomeDir == null) {
			String operatingSystemName = System.getProperty("os.name");
			LOGGER.info("--- Application runs on " + operatingSystemName + " OS ----");
			if (operatingSystemName.contains("Windows")) {
				this.nctRuntimeDirectory = FileSystemConfig.DEFAULT_WINDOWS_NCT_DIR;
				LOGGER.info("--- Using default WINDOWS dir address " + this.nctRuntimeDirectory + " ----");
			} else if (operatingSystemName.contains("Linux")) {
				this.nctRuntimeDirectory = FileSystemConfig.DEFAULT_LINUX_NCT_DIR;
				LOGGER.info("--- Using default LINUX dir address " + this.nctRuntimeDirectory + " ----");

			} else {
				LOGGER.error("---- Unsupported operating system " + operatingSystemName + " !!!");
			}

		} else {
			// If ENV variable is defined, use it
			this.nctRuntimeDirectory = nctHomeDir;
			LOGGER.info("--- Using SYSTEM ENV provided dir address " + this.nctRuntimeDirectory + " ---");
		}
	}

	public String getNctRuntimeDirectory() {
		return nctRuntimeDirectory;
	}

}
