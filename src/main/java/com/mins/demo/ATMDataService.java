package com.mins.demo;

/**
 * 
 * Interface for ATM Data service.
 *
 */
public interface ATMDataService {
	/**
	 * Retrieves list of ATMs for given city name.
	 * @param cityName city name
	 * @return
	 */
    String findATMByCity(String cityName);

    /**
     * Retrieves list of ATMs.
     * @return
     */
    String allATM();
}
