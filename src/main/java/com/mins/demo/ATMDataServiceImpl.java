/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mins.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("atmDataService")
public class ATMDataServiceImpl implements ATMDataService {
	/**
	 * root URI to retrieves list of ATMs.
	 * https://www.ing.nl/api/locator/atms/
	 */
	@Value("${atm.data.root.url}")
	private String atmURLAll;
	/**
	 * rest path retrieves list of ATMs by city name.
	 * /locatedhere/{cityName}
	 */
	@Value("${atm.url.city.filter}")
	private String atmURLCity;

	private final RestTemplate restTemplate;

	public ATMDataServiceImpl(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}
	/**
	 * Retrieves list of ATMs for given city name.
	 * @param cityName city name
	 * @return
	 */
	@Override
	public String findATMByCity(String cityName) {
		String responseStr = this.restTemplate.getForObject(atmURLAll + atmURLCity + cityName, String.class);
		if (responseStr != null && responseStr.trim().length() > 6) {
			responseStr = responseStr.substring(6, responseStr.length());
		}
		return responseStr;
	}
    /**
     * Retrieves list of ATMs.
     * @return
     */
	@Override
	public String allATM() {
		String responseStr = this.restTemplate.getForObject(atmURLAll, String.class);
		if (responseStr != null && responseStr.trim().length() > 6) {
			responseStr = responseStr.substring(6, responseStr.length());
		}
		return responseStr;
	}
}
