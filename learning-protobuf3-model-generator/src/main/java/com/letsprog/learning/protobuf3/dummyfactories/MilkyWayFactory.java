package com.letsprog.learning.protobuf3.dummyfactories;

import java.util.ArrayList;
import java.util.List;

import com.letsprog.learning.protobuf3.dto.Universe.Galaxy;
import com.letsprog.learning.protobuf3.dto.Universe.Planet;
import com.letsprog.learning.protobuf3.dto.Universe.Planet.Moon;
import com.letsprog.learning.protobuf3.dto.Universe.Planet.PlanetType;
import com.letsprog.learning.protobuf3.dto.Universe.Star;

public class MilkyWayFactory {

	public static void main(String[] args) {

		Galaxy milkyWay = MilkyWayFactory.createGalaxy();
		MilkyWayFactory.displayInfo(milkyWay);
		
	}

	public static Galaxy createGalaxy(){
		
		Moon moon1 = Moon.newBuilder()
				.setName("Ariel")
				.setDescription("The brightest moon of Uranus.")
				.build();

		Moon moon2 = Moon.newBuilder()
				.setName("Titania")
				.setDescription("The largest moon of Uranus.")
				.build();

		Moon moon3 = Moon.newBuilder()
				.setName("Umbriel")
				.setDescription("Very dark.")
				.build();

		List<Moon> moons = new ArrayList<Moon>();
		moons.add(moon1);
		moons.add(moon2);
		moons.add(moon3);

		Planet uranus = Planet.newBuilder()
				.setName("Uranus")
				.setDiameter(51800)
				.setRotationPeriod(15.5f)
				.setType(PlanetType.GASEOUS)
				.addAllMoon(moons)
				.build();

		Star sun = Star.newBuilder()
				.setName("Sun")
				.setAge(4.6f)
				.addPlanet(uranus)
				.build();
		Galaxy milkyWay = Galaxy.newBuilder()
				.setName("Milky Way")
				.addStar(sun)
				.build();

		return milkyWay;
	}
	
	public static void displayInfo(Galaxy milkyWay){
		
		System.out.println("Our galaxy name is "+milkyWay.getName()+"."
				+ " It has a star called "+milkyWay.getStar(0).getName()
				+ " whose age is "+milkyWay.getStar(0).getAge()+" billion years.\n"
				+ " This star has a planet called "+milkyWay.getStar(0).getPlanet(0).getName()+".\n"
				+ " This planet is "+milkyWay.getStar(0).getPlanet(0).getType().name()
				+ " and has more than "+milkyWay.getStar(0).getPlanet(0).getMoonCount()+" moons.\n"
				+ " Here we have the description of the most interesting ones :");
		
		System.out.println(milkyWay.getStar(0).getPlanet(0).getMoon(0).getName() 
				+" : "+milkyWay.getStar(0).getPlanet(0).getMoon(0).getDescription());
		
		System.out.println(milkyWay.getStar(0).getPlanet(0).getMoon(1).getName() 
				+" : "+milkyWay.getStar(0).getPlanet(0).getMoon(1).getDescription());
		
		System.out.println(milkyWay.getStar(0).getPlanet(0).getMoon(2).getName() 
				+" : "+milkyWay.getStar(0).getPlanet(0).getMoon(2).getDescription());
		
		
	}
	
}
