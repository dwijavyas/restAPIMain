package files;

public class Payload {

	public static String addPlacePayload() {

		return "{\r\n" + "    \"location\": {\r\n" + "        \"lat\": -38.383494,\r\n"
				+ "        \"lng\": 33.427362\r\n" + "    },\r\n" + "    \"accuracy\": 50,\r\n"
				+ "    \"name\": \"backend house\",\r\n" + "    \"phone_number\": \"(+91) 783 990 3937\",\r\n"
				+ "    \"address\": \"29, kiwi layout, mark 09\",\r\n" + "    \"types\": [\r\n"
				+ "        \"shoe park\",\r\n" + "        \"shop\"\r\n" + "    ],\r\n"
				+ "    \"website\": \"http://google.com\",\r\n" + "    \"language\": \"French-IN\"\r\n" + "}";

	}

	public static String updatePlacePayload(String placeId, String newAddress) {

		return "{\r\n" + "    \"place_id\": \"" + placeId + "\",\r\n" + "    \"address\": \"" + newAddress + "\",\r\n"
				+ "    \"key\": \"qaclick123\"\r\n" + "}";

	}

	public static String deletePlacePayload(String placeId) {

		return "{\r\n" + "    \"place_id\": \"" + placeId + "\",\r\n" + "}";

	}

	//practiseproject
	public static String dummyAPIResponse() {
		
		return "{\r\n"
				+ "\"dashboard\": {\r\n"
				+ "\"purchaseAmount\": 910,\r\n"
				+ "\"website\": \"rahulshettyacademy.com\"\r\n"
				+ "},\r\n"
				+ "\"courses\": [\r\n"
				+ "{\r\n"
				+ "\"title\": \"Selenium Python\",\r\n"
				+ "\"price\": 50,\r\n"
				+ "\"copies\": 6\r\n"
				+ "},\r\n"
				+ "{\r\n"
				+ "\"title\": \"Cypress\",\r\n"
				+ "\"price\": 40,\r\n"
				+ "\"copies\": 4\r\n"
				+ "},\r\n"
				+ "{\r\n"
				+ "\"title\": \"RPA\",\r\n"
				+ "\"price\": 45,\r\n"
				+ "\"copies\": 10\r\n"
				+ "}\r\n"
				+ "]\r\n"
				+ "}\r\n"
				+ "";
			
	}
	
	//libraryapi
	public static String addBookPayload(String isbn, String aisle) {
		
		return "{\r\n"
				+ "    \"name\": \"selenium Automation with Java\",\r\n"
				+ "    \"isbn\": \""+isbn+"\",\r\n"
				+ "    \"aisle\": \""+aisle+"\",\r\n"
				+ "    \"author\": \"ching foe\"\r\n"
				+ "}";
			
	}
	
	//auth for jira api
	public static String authJira() {
		
		
		return "Basic ZHdpamEyMUBnbWFpbC5jb206QVRBVFQzeEZmR0YwZkxWeDJRaDF3Slo2TDJkSXFiOWpXWmlBYlNDSEFwV251Qm5FcWxCcUpJenhYdURTdTN6R1V3SXVZWkJTak1SQ3Y2eHhJR3F5NWFGQk5UMWJzWlFuTGY1b05uSVV5aDRRMGRFUkpuczRELXUydnFWLWZyRE1LS1A4Q2dCeUVXanRSUTE1dnUwNmNNRk5yQ2IxV184NmllUHpOVmNscE1HYnpENmVnOUdJU2NjPTRBRTNBMEYw";
	} 
	
	public static String issueJira() {
		
		return "{\r\n"
				+ "    \"fields\": {\r\n"
				+ "        \"project\": {\r\n"
				+ "            \"key\": \"SCRUM\"\r\n"
				+ "        },\r\n"
				+ "        \"summary\": \"name field not working\",\r\n"
				+ "        \"issuetype\": {\r\n"
				+ "            \"name\": \"Bug\"\r\n"
				+ "        }\r\n"
				+ "    }\r\n"
				+ "}";
		
	}
	
	public static String commentJira(String comment) {
		
		return "{\r\n"
				+ "  \"body\": {\r\n"
				+ "    \"type\": \"doc\",\r\n"
				+ "    \"version\": 1,\r\n"
				+ "    \"content\": [\r\n"
				+ "      {\r\n"
				+ "        \"type\": \"paragraph\",\r\n"
				+ "        \"content\": [\r\n"
				+ "          {\r\n"
				+ "            \"type\": \"text\",\r\n"
				+ "            \"text\": \""+comment+"\"\r\n"
				+ "          }\r\n"
				+ "        ]\r\n"
				+ "      }\r\n"
				+ "    ]\r\n"
				+ "  }\r\n"
				+ "}\r\n"
				+ "";
		
	}
	
	//graphql
	public static String queryPayload(int characterId, int locationId) {
		
		return "{\n" +
			       "  \"query\": \"query($characterId: Int!, $locationId: Int!) {\\n" +
			       "    character(characterId: $characterId) {\\n" +
			       "      name\\n" +
			       "      gender\\n" +
			       "      image\\n" +
			       "      status\\n" +
			       "      origin {\\n" +
			       "        id\\n" +
			       "      }\\n" +
			       "    }\\n" +
			       "    location(locationId: $locationId) {\\n" +
			       "      name\\n" +
			       "      dimension\\n" +
			       "    }\\n" +
			       "    episode(episodeId: 25) {\\n" +
			       "      name\\n" +
			       "      air_date\\n" +
			       "      episode\\n" +
			       "      created\\n" +
			       "    }\\n" +
			       "    characters(filters: {name: \\\"Tom peter\\\"}) {\\n" +
			       "      info {\\n" +
			       "        count\\n" +
			       "        pages\\n" +
			       "      }\\n" +
			       "      result {\\n" +
			       "        id\\n" +
			       "        status\\n" +
			       "        name\\n" +
			       "        gender\\n" +
			       "      }\\n" +
			       "    }\\n" +
			       "    episodes(filters: {episode: \\\"hulu\\\"}) {\\n" +
			       "      info {\\n" +
			       "        count\\n" +
			       "      }\\n" +
			       "      result {\\n" +
			       "        id\\n" +
			       "        characters {\\n" +
			       "          name\\n" +
			       "          gender\\n" +
			       "          image\\n" +
			       "        }\\n" +
			       "      }\\n" +
			       "    }\\n" +
			       "  }\",\n" +
			       "  \"variables\": {\n" +
			       "    \"characterId\": " + characterId + ",\n" +
			       "    \"locationId\": " + locationId + "\n" +
			       "  }\n" +
			       "}";

	}
	
public static String mutationPayload(String characterName) {
		
	return "{\n" +
		       "  \"query\": \"mutation($locationName: String!, $characterName: String!, $episodeName: String!) {\\n" +
		       "    createLocation(location: {name: $locationName, type: \\\"south\\\", dimension: \\\"667\\\"}) {\\n" +
		       "      id\\n" +
		       "    }\\n" +
		       "    createCharacter(character: {name: $characterName, type: \\\"girl\\\", status: \\\"alive\\\", species: \\\"human\\\", gender: \\\"female\\\", image: \\\"ok\\\", originId: 22189, locationId: 22189}) {\\n" +
		       "      id\\n" +
		       "    }\\n" +
		       "    createEpisode(episode: {name: $episodeName, air_date: \\\"2025-07-07\\\", episode: \\\"epi 1\\\"}) {\\n" +
		       "      id\\n" +
		       "    }\\n" +
		       "  }\",\n" +
		       "  \"variables\": {\n" +
		       "    \"locationName\": \"japan\",\n" +
		       "    \"characterName\": \"" + characterName + "\",\n" +
		       "    \"episodeName\": \"squid game\"\n" +
		       "  }\n" +
		       "}";
}
	
}
