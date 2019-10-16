package br.com.dxc;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

public class Utils {

	/**
	 * CLASSE UTILS É UTILIZADA PARA CRIAÇÃO DE MÉTODOS MAIS COMUNS DE SER UTILIZADAS, COMO FORMATAÇÃO DE REAIS, DATA, NÚMERO DE TELEFONE E OUTROS
	 */
	
	// TRATAMENTO NÚMERO CELULAR, RETIRA TODOS OS CARACTERES QUE NÃO SÃO NÚMEROS E RETIRA O ZERO DO INICIO DO DDD
	private static String numeroFormatado(String nrCelular) {
		String tratamentoDeEspacos = nrCelular.replaceAll("\\s", "").replaceAll("[^0-9]","");
		
		if (tratamentoDeEspacos.length() == 12 ) {
			return tratamentoDeEspacos.substring(1);
		}
		
		return tratamentoDeEspacos;
	}
	
	// REMOVE O DDD DO CELULAR OU NÚMERO DO TELEFONE
	private String removeDDD(String telefone) {
        return telefone.replaceAll("\\s", "").replaceAll("[^0-9]","").substring(2); 
	}
	
	
	//CALCULA VALOR TOTAL DA GRID COM JAVA 8 UTILIZANDO REDUCE
	private BigDecimal getValorTotalProgramado() {
        return getListaEntidade.stream()
            .map(Entidade::getAtributoValordaEntidade)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
	  
   //CALCULA VALOR TOTAL DA GRID
   private Double calcularValorTotal() {
        total = 0d;

        for (Entidade apelidoEntidade : (List<Entidade>) getDataList())
            if (apelidoEntidade.getAtributoValordaEntidade() != null)
                total += (apelidoEntidade.getAtributoValordaEntidade());

        return total;
    }
  
  //TRÁS NA GRID OS DADOS EM ORDEM DECRESCENTE
   public static String ordemDecrescente() {
	  return Collections.sort(getDataList(), (Entidade o1, Entidade o2) -> o1.getCodigo().compareTo(o2.getCodigo()));
   }
	  
   // PEGA A DATA ATUAL
   public static Date obterDataAtual() {
       return new Date(System.currentTimeMillis());
   }
   // FORMATA A DATA DIA MES E ANO (BRASIL)
   public static String formatDate(Date data) {
       return new SimpleDateFormat("dd/MM/yyyy").format(data);
   }
   // PEGA O ANO ATUAL
   public static Integer obterAnoAtual() {
       return Calendar.getInstance().get(Calendar.YEAR);
   }

   // FORMATA VALOR 2 CASAS DECIMAIS
   public static String formatNumber(Double number) {
       return String.format("%,.2f", number);
   }

   //FORMATA VALOR 2 CASAS DECIMAIS
   public static String formatNumber(BigDecimal number) {
       return String.format("%,.2f", number);
   }

   //FORMATA VALOR 2 CASAS DECIMAIS
   public static String formatNumberMoney(BigDecimal number) {
       return String.format("R$ %,.2f", number);
   }
	
  // CONVERTENDO O VALOR BIGDECIMAL PARA STRING
   public static BigDecimal converterMoneyStringBigDecimal(String money) throws ParseException {
       if(money == null)
           return null;
       else if (!money.contains(","))
           return new BigDecimal(money);
       Locale local = new Locale("pt", "BR");
       DecimalFormat df = new DecimalFormat("#,##0.00", new DecimalFormatSymbols(local));
       df.parseObject(money);
       df.setParseBigDecimal(true);
       return (BigDecimal) df.parseObject(money);
   }

   public static Double converterMoneyStringDouble(String money) throws ParseException {
       return converterMoneyStringBigDecimal(money).doubleValue();
   }
   
   // REMOVE O CIFRÃO DO VALOR
   public static String converterBigDecimalMoneyMask(BigDecimal valor) {
		Locale ptBr = new Locale("pt", "BR");
		return NumberFormat.getCurrencyInstance(ptBr).format(valor).replace("R$", "");
	}
	
   //ADICIONA 15 ZEROS A ESQUERDA
   HashMap<String, Object> parametros = new HashMap<>();
	parametros.put("NR_DOCUMENTO", StringUtils.leftPad(documento.getNumeroUnicoDocumento().toString(), 15, "0"));
   
}
