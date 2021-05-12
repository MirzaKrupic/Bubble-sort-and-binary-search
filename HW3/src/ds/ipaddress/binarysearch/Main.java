package ds.ipaddress.binarysearch;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import ds.ipaddress.bubblesort.IPAddress;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		IPAddress[] ipAddresses = new IPAddress[100];
		int counter=0;
		Scanner scanner = new Scanner(new File("C:\\Users\\krupi\\Desktop\\hw\\IP-COUNTRY-REGION-CITY-SORTED.csv"));
		while(counter < 100) {
			String[] words = scanner.nextLine().split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");						
			ipAddresses[counter] = new IPAddress(Long.parseLong(words[0].substring(1, words[0].length()-1)), Long.parseLong(words[1].substring(1, words[1].length()-1)), words[2].substring(1, words[2].length()-1), words[3].substring(1, words[3].length()-1), words[4].substring(1, words[4].length()-1), words[5].substring(1, words[5].length()-1));
			counter++;
		}
		
		scanner = new Scanner(System.in);
		System.out.println("Enter IP Address");
		String address = scanner.nextLine();
		String [] split = address.split("\\.");
		long addressnum =Long.parseLong(split[0]) * 16777216 + Long.parseLong(split[1]) * 65536 + Long.parseLong(split[2]) * 256 + Long.parseLong(split[3]);
		int ret = BinarySearch.search(ipAddresses, addressnum);
		if(ret == -1) System.out.println("The data has not been found!");
		else {
			String s = "\"" + ipAddresses[ret].getCountryCode() + "\",\"" + ipAddresses[ret].getCountryName() +"\",\"" +ipAddresses[ret].getRegionName() +"\",\"" + ipAddresses[ret].getCityName()+ "\"\n";		
			System.out.println(s);
		}
	}

}
