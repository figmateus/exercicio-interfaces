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
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Digite os dados do contrato");
        System.out.print("Numero do contrato:");
        int contractNumber = sc.nextInt();
        sc.nextLine();
        System.out.print("Data do contrato (dd/MM/yyyy):");
        String dateContract = sc.nextLine();
        System.out.println(dateContract);
        Date date = formatter.parse(dateContract);


        System.out.print("Valor do contrato:");
        Double contractValue = sc.nextDouble();
        System.out.print("Numero de parcelas:");
        Integer parcel = sc.nextInt();


        Contract contract = new Contract(contractNumber, date, contractValue);
        ContractService service = new ContractService(contract, parcel, new PaypalService());
        service.processContract(contract, parcel);


    }
}