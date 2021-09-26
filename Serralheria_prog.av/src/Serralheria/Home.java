package Serralheria;


import java.util.Scanner;

public class Home {

	public static void main(String[] args) {
		Pessoa clin = new Cliente();
		Pessoa tecnic = new Tecnico();
		Endereco endereco = new Endereco();
		Orcamento orc= new Orcamento();
		FormaPagamento fpg = new FormaPagamento();
		Tecnico tc = new Tecnico();
		Array_List ar = new Array_List();
		// Enter para continuar
		
		System.out.println("****************************************************************");
		System.out.println("|                          Bem Vindo!                          |");
		System.out.println("|            Serralharia Nossa Senhora da Conceição            |");
		System.out.println("****************************************************************");

		for(int i = 0; i < 1; i++) {
			System.out.print(" Pressione enter para continuar.... ");
			System.out.println();
			new Scanner(System.in).nextLine();
		}
		// Fim enter para continuar
		//inicio menu
		System.out.println("Selecione a opção de acesso:\n  1- CLIENTE | 2-TÉCNICO\nOPÇÃO:");
		int menu = menu = new Scanner(System.in).nextInt();

		switch (menu) {

		case 1: 
			
			Scanner end = new Scanner (System.in);
			System.out.println("              CADASTRO            "
					+ "\nCadastre-se para Realizar um Pedido");
			//DADOS PESSOAIS CLIENTE
			Scanner dadosc = new Scanner(System.in);
			
			System.out.println("NOME E SOBRENOME: ");
			clin.setNome(dadosc.nextLine());
			ar.getDados().add(clin.getNome());
			
			System.out.println("TELEFONE PARA CONTATO: ");
			clin.setTelefone(dadosc.nextLine());
			ar.getDados().add(clin.getTelefone());

			System.out.println("CPF: ");
			clin.setCpf(dadosc.nextLine());
			ar.getDados().add(clin.getCpf());

			System.out.println("____________ ENDEREÇO ____________");

			System.out.println("Estado: ");
			endereco.setEstado(dadosc.nextLine());
			ar.getDados().add(endereco.getEstado());

			System.out.println("Cidade: ");
			endereco.setCidade(dadosc.nextLine());
			ar.getDados().add(endereco.getCidade());

			System.out.println("Bairro: ");
			endereco.setBairro(dadosc.nextLine());
			ar.getDados().add(endereco.getBairro());

			System.out.println("Rua: ");
			endereco.setRua(dadosc.nextLine());
			ar.getDados().add(endereco.getRua());

			System.out.println("Ponto de Referencia: ");
			endereco.setPontRefe(dadosc.nextLine());
			ar.getDados().add(endereco.getPontRefe());

			System.out.println("Numero da Residencia: ");
			endereco.setNumero(dadosc.nextLine());
			ar.getDados().add(endereco.getNumero());

			System.out.println("CEP: ");
			endereco.setCep(dadosc.nextLine());
			ar.getDados().add(endereco.getCep());
			//pedido
			System.out.println("****************************************************************");
			System.out.println("|                          SERVIÇO                             |");
			System.out.println("****************************************************************");

			Pedido pedido = new Pedido(menu);

			System.out.println("TIPO DE SERVIÇO A SER EXECUTADO ");
			System.out.println("1- JANELA| 2- PORTA  | 3 - PORTÃO | 4 - TOLDO");
			pedido.settipopedido(dadosc.nextInt());

			Scanner orcamento = new Scanner(System.in);

			System.out.println("Informe a Altura: ");
			orc.setAltura(orcamento.nextDouble());

			System.out.println("Informe a Largura: ");
			orc.setLargura(orcamento.nextDouble());

			System.out.println(orc.getMetrosqd()+" m2");

			System.out.println(" 1-Cor padr o 2-Cor Branca \nTipo de Material: ");
			orc.setTipmaterial(orcamento.nextInt());

			System.out.println(orc.getTotal());
			fpg.setValortot(orc.getTotal());

			Scanner paga = new Scanner(System.in);
			System.out.println("****************************************************************");
			System.out.println("|                       TIPO PAGAMENTO                         |");
			System.out.println("****************************************************************");
			System.out.println("FORMA DE PAGAMENTO:\n ");
			System.out.println("| 1 -CREDITO | 2 -DEBITO | 3 -ESPECIE |");
			while(fpg.getTipopagamento()>3 || fpg.getTipopagamento()<=0) {
			fpg.setTipopagamento(paga.nextInt(), orc.getTotal());

			System.out.println(""+fpg.getTipopagamento()); 

			if(fpg.getTipopagamento() == 1) {
				System.out.println("INFORME A QUANTIDADE DE PARCELAS: ");
				fpg.setVezes(paga.nextInt());

				fpg.setCredito(fpg.getVezes(), orc.getTotal());
				System.out.println();	
				//Complemento cupom fiscal    
				System.out.println("----------------------------------------------------------------");
				System.out.println("|                     DESTINATARIO                             |");
				System.out.println("----------------------------------------------------------------"); 
				System.out.println("\nDados do cliente:\n");
				System.out.println(clin.getNome());
				System.out.println(clin.getCpf());    
				System.out.println(clin.getTelefone());
				System.out.println("\nEndereço:\n");
				System.out.println(endereco.getEstado()+" "+endereco.getCidade());
				System.out.println(endereco.getBairro()+" "+endereco.getRua());
				System.out.println(endereco.getNumero());
				System.out.println(endereco.getCep());
				System.out.println(endereco.getPontRefe());
				
				
				
				System.out.println("\n----------------------------------------------------------------");
				System.out.println("|                          SERVIÇOS                              |");
				System.out.println("----------------------------------------------------------------\n");
				
				
				
				System.out.println("A ser Fabricado:"+ pedido.gettipopedido());
				System.out.println("Altura: "+orc.getAltura()+" m");
				System.out.println("Largura: "+orc.getLargura()+" m");
				System.out.println(orc.getMetrosqd() +" mï¿½");		
				
				
				System.out.println("\n----------------------------------------------------------------");
				System.out.println("|                         REMETENTE                            |");
				System.out.println("----------------------------------------------------------------");
				System.out.println("SERRALHARIA NOSSA SENHORA DA CONCEIÇÃO");
				System.out.println("Av. Uninassau Graças");
				System.out.println("Nº 114          CEP: 52011-210");
				System.out.println("Graças, Recife - PE");
				System.out.println("X--------------------------------------------------------------X");
				System.out.println("Serviço Solicitado com sucesso...");
				
			}if(fpg.getTipopagamento() == 2) {
				System.out.println("----------------------------------------------------------------");
				System.out.println("|                     DESTINATARIO                             |");
				System.out.println("----------------------------------------------------------------"); 
				System.out.println("\nDados do cliente:\n");
				System.out.println(clin.getNome());
				System.out.println(clin.getCpf());    
				System.out.println(clin.getTelefone());
				System.out.println("\nEndereço:\n");
				System.out.println(endereco.getEstado()+" "+endereco.getCidade());
				System.out.println(endereco.getBairro()+" "+endereco.getRua());
				System.out.println(endereco.getNumero());
				System.out.println(endereco.getCep());
				System.out.println(endereco.getPontRefe());
				
				
				System.out.println("\n----------------------------------------------------------------");
				System.out.println("|                          SERVIÇOS                             |");
				System.out.println("----------------------------------------------------------------\n");
				System.out.println("A ser Fabricado:"+ pedido.gettipopedido());
				System.out.println("Altura: "+orc.getAltura()+" m");
				System.out.println("Largura: "+orc.getLargura()+" m");
				System.out.println(orc.getMetrosqd() +" m2");		
				System.out.println("\n----------------------------------------------------------------");
				System.out.println("|                         REMETENTE                            |");
				System.out.println("----------------------------------------------------------------");
				System.out.println("SERRALHARIA NOSSA SENHORA DA CONCEIÇÃO");
				System.out.println("Av. Uninassau Graças");
				System.out.println("Nº 114          CEP: 52011-210");
				System.out.println("Graças, Recife - PE");
				System.out.println("X--------------------------------------------------------------X");
				System.out.println("Serviço Solicitado com sucesso...");
			}if(fpg.getTipopagamento() == 3) {	
				System.out.println("----------------------------------------------------------------");
				System.out.println("|                     DESTINATARIO                             |");
				System.out.println("----------------------------------------------------------------"); 
				System.out.println("\nDados do cliente:\n");
				System.out.println(clin.getNome());
				System.out.println(clin.getCpf());    
				System.out.println(clin.getTelefone());
				System.out.println("\nEndereço:\n");
				System.out.println(endereco.getEstado()+" "+endereco.getCidade());
				System.out.println(endereco.getBairro()+" "+endereco.getRua());
				System.out.println(endereco.getNumero());
				System.out.println(endereco.getCep());
				System.out.println(endereco.getPontRefe());
				System.out.println("\n----------------------------------------------------------------");
				System.out.println("|                           SERVIÇO                              |");
				System.out.println("----------------------------------------------------------------\n");
				System.out.println("A ser Fabricado:"+ pedido.gettipopedido());
				System.out.println("Altura: "+orc.getAltura()+" m");
				System.out.println("Largura: "+orc.getLargura()+" m");
				System.out.println(orc.getMetrosqd() +" m2");		
				System.out.println("\n----------------------------------------------------------------");
				System.out.println("|                         REMETENTE                            |");
				System.out.println("----------------------------------------------------------------");
				System.out.println("SERRALHARIA NOSSA SENHORA DA CONCEIÇÃO");
				System.out.println("Av. Uninassau Graças");
				System.out.println("Nº 114          CEP: 52011-210");
				System.out.println("Graças, Recife - PE");
				System.out.println("X--------------------------------------------------------------X");
				System.out.println("Serviço Solicitado com sucesso...");
		
			}if(fpg.getTipopagamento() == 2) {
				System.out.println("----------------------------------------------------------------");
				System.out.println("|                     DESTINATARIO                             |");
				System.out.println("----------------------------------------------------------------"); 
				System.out.println("\nDados do cliente:\n");
				System.out.println(clin.getNome());
				System.out.println(clin.getCpf());    
				System.out.println(clin.getTelefone());
				System.out.println("\nEndereço:\n");
				System.out.println(endereco.getEstado()+" "+endereco.getCidade());
				System.out.println(endereco.getBairro()+" "+endereco.getRua());
				System.out.println(endereco.getNumero());
				System.out.println(endereco.getCep());
				System.out.println(endereco.getPontRefe());
				System.out.println("\n----------------------------------------------------------------");
				System.out.println("|                          SERVIÇO                               |");
				System.out.println("----------------------------------------------------------------\n");
				System.out.println("A ser Fabricado:"+ pedido.gettipopedido());
				System.out.println("Altura: "+orc.getAltura()+" m");
				System.out.println("Largura: "+orc.getLargura()+" m");
				System.out.println(orc.getMetrosqd() +" m2");		
				System.out.println("\n----------------------------------------------------------------");
				System.out.println("|                         REMETENTE                            |");
				System.out.println("----------------------------------------------------------------");
				System.out.println("SERRALHARIA NOSSA SENHORA DA CONCEIÇÃO");
				System.out.println("Av. Uninassau Graças");
				System.out.println("Nº 114          CEP: 52011-210");
				System.out.println("Graças, Recife - PE");
				System.out.println("X--------------------------------------------------------------X");
				System.out.println("Serviïço Solicitado com sucesso...");
			}if(fpg.getTipopagamento()<=0 || fpg.getTipopagamento()>3 ) {
				System.out.println("TIPO DE PAGAMENTO INVALIDO!!");
				
				System.out.println("ESCOLHA NOVAMENTO O TIPO DE PAGAMENTO\n");
				
				System.out.println("****************************************************************");
				System.out.println("|                       TIPO PAGAMENTO                         |");
				System.out.println("****************************************************************");
				System.out.println("FORMA DE PAGAMENTO:\n ");
				System.out.println("| 1 -CREDITO | 2 -DEBITO | 3 -ESPECIE |");
			}
			}
			System.out.println("1- ENCERRAR | 2 -ACESSO FUNCIONARIO");
			menu = new Scanner(System.in).nextInt();
			switch (menu) {
			case 1: 
				System.out.println("\nObrigado pela preferencia!"); 
				break;
			case 2:
				Scanner acess = new Scanner(System.in);
				System.out.println("\n----------------------------------------------------------------");
				System.out.println("|                        SETOR TÉCNICO                           |");
				System.out.println("----------------------------------------------------------------\n");
				System.out.println("CODIGO DE ACESSO: ");
				double login = acess.nextDouble();
				if (tc.getCodcesso()==login) {
					System.out.println("\n----------------------------------------------------------------");
					System.out.println("|                        SETOR TÉCNICO                           |");
					System.out.println("----------------------------------------------------------------\n");
					System.out.println("Responsaveis:");
					System.out.println(tecnic.getNome());
					System.out.println(tecnic.getCpf());
					System.out.println("\nA SER FABRICADO:\n");
					System.out.println(pedido.gettipopedido());
					System.out.println(orc.getAltura()+" m");
					System.out.println(orc.getLargura()+" m");
					System.out.println(orc.getMetrosqd() +" m2");	
					System.out.println("\nTIPO DE MATERIAL (1 ANODIZADO | 2 BRANCO ANODIZADO)");
					System.out.println(orc.getTipmaterial());
					System.out.println("\nCLIENTE: "+clin.getNome());
				} else {
					System.out.println("* ACESSO NEGADO! *");
				} break;
			} break;
		case 2:
			Scanner acess = new Scanner(System.in);
			System.out.println("\n----------------------------------------------------------------");
			System.out.println("|                        SETOR TÉCNICO                           |");
			System.out.println("----------------------------------------------------------------\n");
			System.out.println("CODIGO DE ACESSO: ");
			double login = acess.nextDouble();
			if (tc.getCodcesso()==login) {
				System.out.println("\n----------------------------------------------------------------");
				System.out.println("|                        SETOR TÉCNICO                           |");
				System.out.println("----------------------------------------------------------------\n");
				System.out.println("Responsaveis:");
				System.out.println(tecnic.getNome());
				System.out.println(tecnic.getCpf());
				System.out.println("\nA SER FABRICADO:\n");
				System.out.println(orc.getAltura()+" m");
				System.out.println(orc.getLargura()+" m");
				System.out.println(orc.getMetrosqd() +" m2");	

				System.out.println("\nTIPO DE MATERIAL (1 ANODIZADO | 2 BRANCO ANODIZADO)");
				System.out.println(orc.getTipmaterial());
				System.out.println("Nome do Cliente: "+ clin.getNome());
				System.out.println("\n"+tecnic.toString());
				System.out.println("\nPOR NÃO HAVER BANCO NÃO EXISTE DADOS EXISTENTE ANTES DE INSERIR DADOS");
			}
		}
	}
}