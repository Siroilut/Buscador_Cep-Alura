import java.util.List;
import java.util.Scanner;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class BuscadorCep {
    public static void main(String[] args) throws Exception {

        String busca = "";
        Scanner leitura = new Scanner(System.in);
        System.out.println("Qual endereço que deseja procurar?");
        var cep = leitura.nextLine();

        Consulta consultaCep = new Consulta();

        try {
            Endereco novoEndereco = consultaCep.BuscarEndereço(cep);
            System.out.println(novoEndereco);
            GeradorJson geradorJson = new GeradorJson();
            geradorJson.salvarJson(novoEndereco);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println("aplicação finalizada!");
        }

    }

}
