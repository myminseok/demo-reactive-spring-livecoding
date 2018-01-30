/*
 * Copyright 2002-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package car.location;


import car.Car;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;


@RestController
public class CarLocationController {

	private final CarRepository repository;


	public CarLocationController(CarRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/cars")
	public Flux<Car> getCars() {
		return this.repository.findAll().log();
	}

	@GetMapping(path = "/cars", produces = "application/stream+json")
	public Flux<Car> getCarStream() {
		return this.repository.findCarsBy().log();
	}

	@GetMapping(path = "/cars", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Car> getCarStream2() {
		return this.repository.findCarsBy().log();
	}

	// WebFlux only
	@PostMapping(path="/cars", consumes = "application/stream+json")
	@ResponseStatus(HttpStatus.CREATED)
	public Flux<Car> loadCars(@RequestBody Flux<Car> cars) {
		return this.repository.insert(cars);
	}



}
