package com.fabriciovalli.phorest.application;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.fabriciovalli.phorest.application.bo.ClientBO;
import com.fabriciovalli.phorest.application.bo.VoucherBO;
import com.fabriciovalli.phorest.application.exception.BusinessException;
import com.fabriciovalli.phorest.application.model.Client;
import com.fabriciovalli.phorest.application.model.Voucher;
import com.fabriciovalli.phorest.application.service.IClientService;
import com.fabriciovalli.phorest.application.service.IVoucherService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public IClientService getClientService() {
		return new ClientBO();
	}

	@Bean
	public IVoucherService getVoucherService() {
		return new VoucherBO();
	}

	@Override
	public void run(String... args) throws Exception {

		int option = 0;
		do {
			System.out.println("Type the operation to be executed:");
			System.out.println("1. Search Client by email");
			System.out.println("2. Search Client by phone");
			System.out.println("0. Exit");

			option = s.nextInt();
			handleMenuOption(option);
		} while (option != 0);
		System.in.read();
		s.close();
		System.exit(0);
	}

	public void handleMenuOption(int option) {
		IClientService clientService = getClientService();

		if (option == 0) {
			System.out.println("Program is about to finish...");
		} else if (option == 1) {
			System.out.print("Please enter the client email: ");
			String email = s.next();

			try {
				List<Client> clients = clientService.findClient(email, null);
				displayClients(clients);
				chooseClientAndGenerateVoucher(clients);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return;
			}

		} else if (option == 2) {
			System.out.print("Please enter the client phone: ");
			String phone = s.next();

			try {
				List<Client> clients = clientService.findClient(null, phone);
				displayClients(clients);
				chooseClientAndGenerateVoucher(clients);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println("Press ENTER to continue...");
		try {
			System.in.read();
		} catch (IOException e) {
			System.exit(1);
		}
	}

	private void displayClients(List<Client> clients) {
		System.out.println();
		System.out.println("Choose a client to create a voucher (Type 0 to return): ");
		for (int i = 1; i <= clients.size(); i++) {
			System.out.println(i + ". " + clients.get(i - 1).toString());
		}
	}

	private void chooseClientAndGenerateVoucher(List<Client> clients) {
		IVoucherService voucherService = getVoucherService();

		int clientIndex = 0;
		try {
			clientIndex = s.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Could not read input");
			return;
		}
		Client client = clients.get(clientIndex - 1);
		Voucher voucher = new Voucher();
		voucher.setClientId(client.getClientId());
		Voucher createdVoucher;
		try {
			createdVoucher = voucherService.createVoucher(voucher);
			System.out.println("Voucher created for client: " + client.toString());
			System.out.println("Voucher info: " + createdVoucher.toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}
	}

}
