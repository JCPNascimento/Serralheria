package Serralheria;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Home {

	public static void main(String[] args) {
		Pessoa clin = new Cliente();
		Pessoa tecnic = new Tecnico();
		Endereco endereco = new Endereco();
		Orcamento orc= new Orcamento();
		FormaPagamento fpg = new FormaPagamento();
		Tecnico tc = new Tecnico();
		Dados ar = new Dados();

		int n = 0;

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
		int menu = 0;
		Scanner m = new Scanner(System.in);

		do {
			do {

				try {
					System.out.println("Selecione a opção de acesso:\n  1- CLIENTE | 2-TÉCNICO\nOPÇÃO:");
					menu = m.nextInt();	
				} catch (InputMismatchException e) {
					System.out.println("*******************************************");
					System.out.println("Ops, Digite um código valido.");
					System.out.println("*******************************************");
				}
				m.nextLine();

			} while( menu == 0);

			if(menu != 1 && menu != 2) {
				System.out.println("*********************************************");
				System.out.println("Ops...Digite 1 para Cliente ou 2 Para Tecnico");
				System.out.println("*********************************************");
			}

		} while(menu != 1 && menu != 2);


		switch (menu) {

		case 1: 

			//			Scanner end = new Scanner (System.in);
			System.out.println("              CADASTRO            "
					+ "\nCadastre-se para Realizar um Pedido");

			//DADOS PESSOAIS CLIENTE
			Scanner dadosc = new Scanner(System.in);

			boolean validarnome = false;
			String nome;
			do {
				validarnome = false;

				System.out.println("NOME E SOBRENOME: ");
				//	nome = dadosc.nextLine();

				clin.setNome(dadosc.nextLine());
				ar.find().add(clin.getNome());

				Pattern p = Pattern.compile("([0-9])");
				Matcher ma = p.matcher(clin.getNome());

				if (ma.find()) {
					System.out.println("*******************************************");
					System.out.println("voce não pode inserir números neste campo! ");
					System.out.println("*******************************************");

					validarnome = true;
				}
			}while (validarnome);

			boolean val;
			boolean valnum;
			int count = 0;
			String aux;

			do {
				do {
					count = 0;
					System.out.println("Telefone: ");
					aux = dadosc.nextLine();

					if(aux.length() != 11) {        			
						System.out.println("*******************************************");
						System.out.println("Minimo 11 digitos");
						System.out.println("*******************************************");
						count++;
					}
				}while(count == 1);
				valnum = validarCodigoNumber(aux);

				clin.setTelefone(aux);
				ar.find().add(clin.getTelefone());

			}while(valnum);

			do {
				do {
					count = 0;
					System.out.println("CPF: ");
					aux = dadosc.nextLine(); //sair quebra exessao
					clin.setCpf(aux);
					if(aux.length() != 11) {
						System.out.println("*******************************************");
						System.out.println("Minimo 11 digitos");
						System.out.println("*******************************************");
						count++;
					}
				}while(count == 1);
				valnum = validarCodigoNumber(aux);
				clin.setTelefone(aux);

				//  clin.setCpf(dadosc.nextLine());
				ar.find().add(clin.getCpf());
			}while(valnum);

			System.out.println("Itens da lista:");
			System.out.println(ar.find());

			System.out.println("CPF a ser removido: ");
			clin.setCpf(dadosc.nextLine());
			ar.remover(clin.getCpf());

			System.out.println("Itens da lista:");
			System.out.println(ar.find());

			System.out.println("Insira o item a ser procurado na lista:");
			String searchString = dadosc.nextLine();

			for (String curVal : ar.dados){
				if (curVal.contains(searchString)){
					ar.listClone.add(curVal);
				}
			}

			System.out.println(ar.listClone);

			System.out.println("____________ ENDERECO ____________");

			do {
				System.out.println("Estado: ");
				String end = dadosc.nextLine();
				val = validarcodigo(end);
				endereco.setEstado(end);
			}while(val);
			//			endereco.setEstado(dadosc.nextLine());
			ar.find().add(endereco.getEstado());

			do {
				System.out.println("Cidade: ");
				String cid = dadosc.nextLine();
				val = validarcodigo(cid);
				endereco.setCidade(cid);
			}while(val);
			//			System.out.println("Cidade: ");
			//			endereco.setCidade(dadosc.nextLine());
			ar.find().add(endereco.getCidade());

			do {
				System.out.println("Bairro: ");
				String bar = dadosc.nextLine();
				val = validarcodigo(bar);
				endereco.setBairro(bar);

			}while(val);
			//			endereco.setBairro(dadosc.nextLine());
			ar.find().add(endereco.getBairro());

			do {
				System.out.println("RUA: ");
				String rua = dadosc.nextLine();
				val = validarcodigo(rua);
				endereco.setRua(rua);
			}while(val);
			//			endereco.setRua(dadosc.nextLine());
			ar.find().add(endereco.getRua());

			do {
				System.out.println("PONTO DE REFERENCIA: ");
				String ref = dadosc.nextLine();
				val = validarcodigo(ref);
				endereco.setPontRefe(ref);
			}while(val);
			//			endereco.setPontRefe(dadosc.nextLine());
			ar.find().add(endereco.getPontRefe());

			do {
				System.out.println("NUMERO: ");
				String num = dadosc.nextLine();
				valnum = validarCodigoNumber(num);
				endereco.setNumero(num);
			}while(valnum);
			//			endereco.setNumero(dadosc.nextLine());
			ar.find().add(endereco.getNumero());

			do {
				do {
					count = 0;
					System.out.println("CEP: ");
					aux = dadosc.nextLine();
					if(aux.length() != 8) {
						System.out.println("*******************************************");
						System.out.println("Minimo 8 digitos");
						System.out.println("*******************************************");
						count++;
					}
				}while(count == 1);			
				valnum = validarCodigoNumber(aux);
				endereco.setCep(aux);
				ar.find().add(endereco.getCep());

			}while(valnum);
			//			endereco.setCep(dadosc.nextLine());


			//pedido
			System.out.println("****************************************************************");
			System.out.println("|                          SERVICO                             |");
			System.out.println("****************************************************************");

			Pedido pedido = new Pedido(menu);
			
			int j = 0;
			int p =0;
			do {

				try {

					System.out.println("Quantos Serviços serão feitos ?");
					Scanner s = new Scanner(System.in);
					n = s.nextInt();
					j++;
				}catch(InputMismatchException e){

					System.out.println("****************************************************************");
					System.out.println("Ops, Digite um número valido.");
					System.out.println("****************************************************************");

				}

			}while(j==0);

			j=0;

			for(int i = 0; i < n; i++) {


				do {
                    try {
                        do {
                        System.out.println("TIPO DE SERVICO A SER EXECUTADO ");
                        System.out.println("1- JANELA| 2- PORTA  | 3 - PORT�O | 4 - TOLDO");
                        int rec = dadosc.nextInt();
                        if(rec == 1 || rec == 2 || rec ==3 || rec == 4) {
                            pedido.settipopedido(rec);
                            j++;
                            p++;

                        }else {
                            System.out.println("**");
                            System.out.println("Ops, Digite um número valido.");
                            System.out.println("**");

                        }

                         }while(p == 0);

                    }catch(InputMismatchException e){

                        System.out.println("**");
                        System.out.println("Ops, Digite um número valido.");
                        System.out.println("**");

                    }
                    dadosc.nextLine();

                }while(j==0 );

                j=0;

				Scanner orcamento = new Scanner(System.in);

				
				do {	
					do {

						try {
							System.out.println("Informe a Altura: ");
							orc.setAltura(orcamento.nextDouble());
							j++;

						}catch(InputMismatchException e){

							System.out.println("****************************************************************");
							System.out.println("Ops, Digite uma altura valida.");
							System.out.println("****************************************************************");
						}
						orcamento.nextLine();
					}while(j==0);
					j=0;
					if(orc.getAltura() == 0) {

						System.out.println("****************************************************************");
						System.out.println("Ops, Digite uma altura Maior que 0.");
						System.out.println("****************************************************************");

					}
				}while(orc.getAltura()==0);
				j=0;

				do {
					do {

						try {
							System.out.println("Informe a Largura: ");
							orc.setLargura(orcamento.nextDouble());
							j++;

						}catch(InputMismatchException e){
							System.out.println("****************************************************************");
							System.out.println("Ops, Digite uma largura valida.");
							System.out.println("****************************************************************");                    
						}
						orcamento.nextLine();
					}while(j==0);
					j=0;
					if(orc.getLargura()==0){
						System.out.println("****************************************************************");
						System.out.println("Ops, Digite uma largura Maior que 0.");
						System.out.println("****************************************************************");

					}
				}while(orc.getLargura()==0);
				j=0;

				System.out.println(orc.getMetrosqd()+" m2");
				do {
					do {
						try {
							System.out.println(" 1-Cor padr o 2-Cor Branca \nTipo de Material: ");
							orc.setTipmaterial(orcamento.nextInt());
							j++;
						}catch(InputMismatchException e){

							System.out.println("****************************************************************");
							System.out.println("Ops, Digite uma cor valida.");
							System.out.println("****************************************************************");

						}
						orcamento.nextLine();
					}while(j==0);
					if(orc.getTipmaterial()!=1 && orc.getTipmaterial()!=2) {
						j=0;

						System.out.println("****************************************************************");
						System.out.println("Ops, Digite uma cor valida.");
						System.out.println("****************************************************************");
					}
				}while(orc.getTipmaterial()!=1 && orc.getTipmaterial()!=2);
				j=0;

				System.out.println(orc.getTotal());
				fpg.setValortot(orc.getTotal());
			}

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

					do {
						try {
							System.out.println("INFORME A QUANTIDADE DE PARCELAS: ");
							fpg.setVezes(paga.nextInt());
							fpg.setCredito(fpg.getVezes(), orc.getTotal());
							j++;
						} catch (InputMismatchException e) {
							System.out.println("****************************************************************");
							System.out.println("voce nao pode digitar letras.");
							System.out.println("****************************************************************");

						}
						paga.nextLine();
					}while(j==0);
					j=0;

					//Complemento cupom fiscal    
					System.out.println("----------------------------------------------------------------");
					System.out.println("|                     DESTINATARIO                             |");
					System.out.println("----------------------------------------------------------------"); 
					System.out.println("\nDados do cliente:\n");
					System.out.println(clin.getNome());
					System.out.println(clin.getCpf());    
					System.out.println(clin.getTelefone());
					System.out.println("\nEndere�o:\n");
					System.out.println(endereco.getEstado()+" "+endereco.getCidade());
					System.out.println(endereco.getBairro()+" "+endereco.getRua());
					System.out.println(endereco.getNumero());
					System.out.println(endereco.getCep());
					System.out.println(endereco.getPontRefe());
					System.out.println("\n----------------------------------------------------------------");
					System.out.println("|                          SERVI�O                             |");
					System.out.println("----------------------------------------------------------------\n");
					System.out.println("A ser Fabricado:"+ pedido.gettipopedido());
					System.out.println("Altura: "+orc.getAltura()+" m");
					System.out.println("Largura: "+orc.getLargura()+" m");
					System.out.println(orc.getMetrosqd() +" m�");		
					System.out.println("\n----------------------------------------------------------------");
					System.out.println("|                         REMETENTE                            |");
					System.out.println("----------------------------------------------------------------");
					System.out.println("SERRALHARIA NOSSA SENHORA DA CONCEIÇÂO");
					System.out.println("Av. Uninassau Graças");
					System.out.println("N� 114          CEP: 52011-210");
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
					System.out.println("|                          SERVIÇO                             |");
					System.out.println("----------------------------------------------------------------\n");
					System.out.println("A ser Fabricado:"+ pedido.gettipopedido());
					System.out.println("Altura: "+orc.getAltura()+" m");
					System.out.println("Largura: "+orc.getLargura()+" m");
					System.out.println(orc.getMetrosqd() +" m�");		
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
					System.out.println("\nEndere�o:\n");
					System.out.println(endereco.getEstado()+" "+endereco.getCidade());
					System.out.println(endereco.getBairro()+" "+endereco.getRua());
					System.out.println(endereco.getNumero());
					System.out.println(endereco.getCep());
					System.out.println(endereco.getPontRefe());
					System.out.println("\n----------------------------------------------------------------");
					System.out.println("|                          SERVIÇO                             |");
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
					System.out.println("|                           SERVIÇO                              |");
					System.out.println("----------------------------------------------------------------\n");
					System.out.println("A ser Fabricado:"+ pedido.gettipopedido());
					System.out.println("Altura: "+orc.getAltura()+" m");
					System.out.println("Largura: "+orc.getLargura()+" m");
					System.out.println(orc.getMetrosqd() +" m�");		
					System.out.println("\n----------------------------------------------------------------");
					System.out.println("|                         REMETENTE                            |");
					System.out.println("----------------------------------------------------------------");
					System.out.println("SERRALHARIA NOSSA SENHORA DA CONCEIÇÃO");
					System.out.println("Av. Uninassau Graças");
					System.out.println("Nº 114          CEP: 52011-210");
					System.out.println("Graças, Recife - PE");
					System.out.println("X--------------------------------------------------------------X");
					System.out.println("Serviço Solicitado com sucesso...");
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

			do{
	            do {
	                try {

	                    System.out.println("1- ENCERRAR | 2 -ACESSO FUNCIONARIO");
	                    menu = new Scanner(System.in).nextInt();
	                    j++;

	                } catch(InputMismatchException e) {
						System.out.println("****************************************************************");
	                    System.out.println("Ops, Voce nao pode digitar letras nesse campo!");
						System.out.println("****************************************************************");

	                }
           }while(j==0);

	            if(menu != 1 && menu!=2) {
	                j=0;

	                    System.out.println("****************************************************************");
	                    System.out.println("Ops...Digite 1 para Encerrar ou 2 Para Acesso funcionario");
	                	System.out.println("****************************************************************");
	            }

	         }while(menu != 1 && menu!=2);

	            j = 0;

			switch (menu) {
			case 1: 
				System.out.println("\nObrigado pela preferencia!"); 
				break;
			case 2:
				Scanner acess = new Scanner(System.in);
				System.out.println("\n----------------------------------------------------------------");
				System.out.println("|                        SETOR T�CNICO                           |");
				System.out.println("----------------------------------------------------------------\n");
				System.out.println("CODIGO DE ACESSO: ");
				double login = acess.nextDouble();
				if (tc.getCodcesso()==login) {
					System.out.println("\n----------------------------------------------------------------");
					System.out.println("|                        SETOR T�CNICO                           |");
					System.out.println("----------------------------------------------------------------\n");
					System.out.println("Responsaveis:");
					System.out.println(tecnic.getNome());
					System.out.println(tecnic.getCpf());
					System.out.println("\nA SER FABRICADO:\n");
					System.out.println(pedido.gettipopedido());
					System.out.println(orc.getAltura()+" m");
					System.out.println(orc.getLargura()+" m");
					System.out.println(orc.getMetrosqd() +" m�");	
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
			System.out.println("|                        SETOR T�CNICO                           |");
			System.out.println("----------------------------------------------------------------\n");
			System.out.println("CODIGO DE ACESSO: ");
			double login = acess.nextDouble();
			if (tc.getCodcesso()==login) {
				System.out.println("\n----------------------------------------------------------------");
				System.out.println("|                        SETOR T�CNICO                           |");
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
				System.out.println("\nPOR NÃO HAVER BANCO N�O EXISTE DADOS EXISTENTE ANTES DE INSERIR DADOS");
			}

		}
	}

	public static boolean validarcodigo(String codigo){

		boolean validarcodigo;


		validarcodigo = false;



		Pattern p = Pattern.compile("([0-9])");
		Matcher ma = p.matcher(codigo);

		if (ma.find()) {
			System.out.println("*******************************************");
			System.out.println("voce não pode inserir números neste campo!");
			System.out.println("*******************************************");

			validarcodigo = true;
		}
		return validarcodigo;
	}

	public static boolean validarCodigoNumber(String codigo) {
		boolean validarCodigo = false;

		Pattern p = Pattern.compile("[0-9]");
		Matcher ma = p.matcher(codigo);

		if(!ma.find()) {
			System.out.println("******************************************");
			System.out.println("voce não pode inserir letras neste campo!");
			System.out.println("********************************************");

			validarCodigo = true;
		}
		return validarCodigo;
	}
}