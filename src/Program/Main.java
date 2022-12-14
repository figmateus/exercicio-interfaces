package Program;

import model.entities.Contract;
import model.services.ContractService;
import model.services.PaypalService;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Digite os dados do contrato");
        System.out.print("Numero do contrato:");
        int contractNumber = sc.nextInt();
        sc.nextLine();
        System.out.print("Data do contrato (dd/MM/yyyy):");
        LocalDate date = LocalDate.parse(sc.nextLine(), fmt);

        System.out.print("Valor do contrato:");
        Double contractValue = sc.nextDouble();
        Contract contract = new Contract(contractNumber, date, contractValue);
        System.out.print("Numero de parcelas:");
        Integer parcel = sc.nextInt();

        ContractService service = new ContractService(new PaypalService());
        service.processContract(contract, parcel);
    }
}