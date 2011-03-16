
package br.com.dba.timesheet.util;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.StringTokenizer;


/**
 * 
 * @author Fabio Oliveira de Pinho
 * 
 * @version 1.0
 */
public final class DataUtil {

	private static final int MILLIS_DIA = 86400000;
	public static final int DIA = 1;
	public static final int MES = 2;
	public static final int ANO = 3;
	private static final Locale locale = new Locale("pt", "BR");


	/**
	 * Validação de datas simples no formato dd/MM/yyyy
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isSimpleDateValid(String value) {
		try {
			/*
			 * Garante a máscara
			 */
			if (value.length() < 10) {
				value = MaskUtil.appendDateMask(value);
			}

			DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
			f.setLenient(false);
			f.parse(value);

			return true;
		} catch (ParseException e) {
			return false;
		}
	}

	/**
	 * Formata o date.
	 * 
	 * @param data
	 *            Data que será formatada.
	 * @return String formatada.
	 */
	public static String formatar_hhmm(Date data) {
		return formatarData_hhmm(data, "HH:mm");
	}

	/**
	 * Formata uma data
	 * 
	 * @param data
	 *            Dtaa que será formatada.
	 * @param pattern
	 *            Pattern usado na formatação.
	 * @return String da data formatada.
	 */
	protected static String formatarData_hhmm(Date data, String pattern) {
		String res = null;
		res = new SimpleDateFormat(pattern, new Locale("pt", "BR"))
		.format(data);
		return res;
	}

	/**
	 * Retorna a data no formato String dd/MM/yyyy
	 * 
	 * @param value
	 * @return
	 */
	public static String formatSimpleDate(Date value) {		
		return formatDate(value,"dd/MM/yyyy");
	}

	/**
	 * Retorna a data no formato String de acordo com o patern enviado.
	 * @param value - data a ser transformada.
	 * @param patern - padrão para a transformação da data em String.
	 * @return data como String no padrão enviado.
	 */
	public static String formatDate(Date value, String patern) {
		if (value != null) {
			DateFormat f = new SimpleDateFormat(patern);
			f.setLenient(false);
			return f.format(value);
		} else {
			return "";
		}
	}	

	/**
	 * 
	 * @return Data atual no formato definido pelo método formatSimpleDate
	 */
	public static String todayAsString() {
		return formatSimpleDate(new Date());
	}

	/**
	 * 
	 * @return Data atual no formato definido pelo método formatSimpleDate
	 */
	public static String todayAsString(String pattern) {
		return formatarData_hhmm(new Date(), pattern);
	}

	/**
	 * Retorna um objeto Date com formato dd/MM/yyyy
	 * 
	 * @param value
	 * @return
	 * @throws ParseException
	 */
	public static Date toSimpleDate(String value) throws ParseException {
		DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		f.setLenient(false);
		return f.parse(value);
	}

	/**
	 * Retorna um date adicionando a hora.
	 * 
	 * @param date
	 * @param hour
	 * @return
	 */
	public static Date toCompleteDate(Date date, Date hour) {
		Date result = new Date();
		if (hour != null) {
			Calendar cHora = Calendar.getInstance();
			cHora.setTime(hour);
			cHora.add(Calendar.HOUR, -3);
			result.setTime(date.getTime() + cHora.getTimeInMillis());
		}else {
			result.setTime(date.getTime());
		}
		return result;
	}

	/**
	 * Validação de datas de acordo com um formato
	 * 
	 * @param value
	 * @param format
	 * @return
	 */
	public static boolean isDateValid(String value, String format) {
		try {
			DateFormat f = new SimpleDateFormat(format);
			f.setLenient(false);
			f.parse(value);

			return true;
		} catch (ParseException e) {
			return false;
		}
	}

	/**
	 * Validação de datas de acordo com o padrão dd/MM/yyyy
	 * 
	 * @param value
	 * @return true - data válida
	 */
	public static boolean isDateValid(String value) {
		return isDateValid(value, "dd/MM/yyyy");
	}

	/**
	 * Verifica se o String representa uma hora minuto válidos.
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isHourMinuteValid(String value) {
		try {
			DateFormat f = new SimpleDateFormat("HH:mm");
			f.setLenient(false);
			f.parse(value);

			return true;
		} catch (ParseException e) {
			return false;
		}
	}

	/**
	 * Verifica se uma data é igual a data atual (hoje). O teste compara o ano,
	 * o mês e o dia.
	 * 
	 * @param date
	 * @return
	 */
	public static boolean isToday(Date date) {
		Calendar hoje = Calendar.getInstance();

		Calendar param = new GregorianCalendar();
		param.setTime(date);

		return (hoje.get(Calendar.DAY_OF_MONTH) == param
				.get(Calendar.DAY_OF_MONTH)
				&& hoje.get(Calendar.MONTH) == param.get(Calendar.MONTH) && hoje
				.get(Calendar.YEAR) == param.get(Calendar.YEAR));
	}

	private DataUtil() {

	}

	/**
	 * @param dataStr
	 * @return Date - Retorna o objeto Date correspondente ao string passado
	 *         como parametro
	 * @throws ParseException
	 */
	public static Date toDate(String dataStr) throws ParseException {
		SimpleDateFormat df = null;
		Date data = null;
		if (dataStr != null && !dataStr.equals("")) {
			df = new SimpleDateFormat("dd/MM/yyyy");
			data = df.parse(dataStr);
		}
		return data;
	}


	/**
	 * @param dataStr
	 * @return Date - Retorna o objeto Date correspondente ao string passado
	 *         como parametro
	 * @throws ParseException
	 */
	public static Date toDate(String dataStr, String parser) throws ParseException {
		SimpleDateFormat df = null;
		Date data = null;
		if (dataStr != null && !dataStr.equals("")) {
			df = new SimpleDateFormat(parser);
			data = df.parse(dataStr);
		}
		return data;
	}

	/**
	 * Converte uma hora no formato String para um objeto Date.
	 * 
	 * @param hourStr
	 * @return
	 * @throws ParseException
	 */
	public static Date toHour(String hourStr) throws ParseException {
		SimpleDateFormat df = null;
		Date data = null;
		if (hourStr != null && !hourStr.equals("")) {
			df = new SimpleDateFormat("HH:mm");
			data = df.parse(hourStr);
		}
		return data;
	}

	/**
	 * Converte um java.util.Date num Calendar.
	 * 
	 * @param data
	 * @return
	 */
	public static Calendar toCalendar(Date data) {
		if (data != null) {
			Calendar result = Calendar.getInstance();
			result.setTime(data);

			return result;
		} else {
			return null;
		}
	}

	/**
	 * Converte um texto representando uma data completa para um java.util.Date
	 * 
	 * @param hourStr
	 * @return
	 * @throws ParseException
	 */
	public static Date toHourComplete(String completeDateStr)
	throws ParseException {
		SimpleDateFormat df = null;
		Date data = null;
		if (completeDateStr != null && !completeDateStr.equals("")) {
			df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss SS");
			data = df.parse(completeDateStr);
		}
		return data;
	}

	/**
	 * Converte um texto representando uma data completa para um java.util.Date
	 * 
	 * @param hourStr
	 * @return
	 * @throws ParseException
	 */
	public static Date toDateHour(String completeDateStr) throws ParseException {
		SimpleDateFormat df = null;
		Date data = null;
		if (completeDateStr != null && !completeDateStr.equals("")) {
			df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			data = df.parse(completeDateStr);
		}
		return data;
	}

	/**
	 * Retorna a data atual no formato dd/MM/yyyy HH:mm
	 * 
	 * @return String
	 */
	public static String toDateHourCurrent() {
		SimpleDateFormat df = null;
		Date date = new Date();
		String data = "";
		df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		data = df.format(date);
		return data;
	}

	/**
	 * Dado um data base, obtém um Timestamp com a data no ultimo milisegundo da
	 * data em questão.
	 * 
	 * @param dataBase
	 * @return
	 */
	public static Timestamp getMaxDateTime(java.util.Date dataBase) {
		Calendar c = Calendar.getInstance();
		c.setTime(dataBase);

		/*
		 * Dia posterior
		 */
		c.add(Calendar.DAY_OF_MONTH, 1);
		/*
		 * Seta os campos de hora para ZERO
		 */
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		/*
		 * Diminui 1 milisegundo para retornar a data anterior no seu último
		 * "instante"
		 */
		c.add(Calendar.MILLISECOND, -1);

		return new Timestamp(c.getTimeInMillis());
	}

	/**
	 * Dado um data base, obtém um Timestamp com a data no primeiro milisegundo
	 * da data em questão.
	 * 
	 * @param dataBase
	 * @return
	 */
	public static Timestamp getMinDateTime(java.util.Date dataBase) {
		Calendar c = Calendar.getInstance();
		c.setTime(dataBase);

		/*
		 * Seta os campos de hora para ZERO
		 */
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);

		return new Timestamp(c.getTimeInMillis());
	}

	/**
	 * Retorna os dias existentes entre duas datas de formato dd/MM/yyyy.
	 * 
	 * @param dateStart
	 * @param dateEnd
	 * @return
	 */
	public static long getDaysBeteweenDates(String dateStart, String dateEnd)
	throws Exception {
		return getDaysBeteweenDates(toSimpleDate(dateStart),
				toSimpleDate(dateEnd));
	}

	/**
	 * Retorna os dias existentes entre duas datas.
	 * 
	 * @param dateStart
	 * @param dateEnd
	 * @return
	 */
	public static long getDaysBeteweenDates(Date dateStart, Date dateEnd)
	throws Exception {
		long dias = 0;

		if (dateStart != null && dateStart != null) {
			dias = Math.abs(dateStart.getTime() - dateEnd.getTime()) / 86400000;
		} else
			throw new Exception("Data informada está nula.");

		return dias;
	}


	/**
	 * Converte um String num Timestamp. O String deve ter o formato 'dd/MM/yyyy
	 * HH:mm:ss SSSSS'.
	 * 
	 * @param value
	 * @return
	 * @throws ParseException
	 */
	public static Timestamp toTimestampMillis(String value)
	throws ParseException {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss SSSSSS");
		return new Timestamp(df.parse(value).getTime());
	}

	/**
	 * Converte um String num Timestamp. O String deve ter o formato 'dd/MM/yyyy
	 * HH:mm:ss'.
	 * 
	 * @param value
	 * @return
	 * @throws ParseException
	 */
	public static Timestamp toTimestamp(String value) throws ParseException {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return new Timestamp(df.parse(value).getTime());
	}

	/**
	 * Converte um Date num Timestamp.
	 * 
	 * @param value
	 * @return
	 * @throws ParseException
	 */
	public static Timestamp toTimestamp(Date date) throws ParseException {
		return new Timestamp(date.getTime());
	}

	/**
	 * Informa se o período informado é valido.
	 * 
	 * @param dataInicial
	 * @param dataFinal
	 * @return
	 * @throws SystemException
	 */
	public static boolean isPeriodValid(final Date dataInicial,final Date dataFinal){
		return  dataInicial.before(dataFinal);
	}

	/**
	 * Informa se o período informado é valido.
	 * 
	 * @param dataInicial
	 * @param dataFinal
	 * @return
	 * @throws ParseException
	 * @throws SystemException
	 */
	public static boolean isPeriodValid(final String dataInicial,
			final String dataFinal) throws ParseException{
		return isPeriodValid(toSimpleDate(dataInicial), toSimpleDate(dataFinal));
	}

	/**
	 * Informa se o período informado é valido e está entre a quantidade minima
	 * e máxima de dias informados.
	 * 
	 * @param dataInicial
	 * @param dataFinal
	 * @param qtdMinDias
	 * @param qtdMaxDias
	 * @return
	 * @throws ParseException
	 * @throws SystemException
	 */
	public static boolean isPeriodValid(final Date dataInicial,
			final Date dataFinal, final Long qtdMinDias, final Long qtdMaxDias)
	throws Exception {
		boolean ok = isPeriodValid(dataInicial, dataFinal);

		if (ok) {
			if (qtdMinDias != null && qtdMaxDias != null) {
				final long qtdDias = getDaysBeteweenDates(dataInicial,
						dataFinal);
				if (qtdDias < qtdMinDias.longValue()
						|| qtdDias > qtdMaxDias.longValue())
					ok = false;
			} 
		}

		return ok;
	}

	/**
	 * Informa se o período informado é valido e está entre a quantidade minima
	 * e máxima de dias informados.
	 * 
	 * @param dataInicial
	 * @param dataFinal
	 * @param qtdMinDias
	 * @param qtdMaxDias
	 * @return
	 * @throws ParseException
	 * @throws SystemException
	 */
	public static boolean isPeriodValid(final String dataInicial,
			final String dataFinal, final Long qtdMinDias, final Long qtdMaxDias)
	throws Exception {
		return isPeriodValid(toSimpleDate(dataInicial),
				toSimpleDate(dataFinal), qtdMinDias, qtdMaxDias);
	}

	/**
	 * Verifica se data é depois de hoje.
	 * 
	 * @param date
	 * @return
	 */
	public static boolean isDateAfterToday(final Date date) {
		if(date!=null){
			Date today = today_ddMMyyyy();
			return date.after(today);
		}
		return false;
	}

	/**
	 * Verifica se data é depois de hoje.
	 * 
	 * @param dateStr
	 * @return
	 * @throws ParseException
	 */
	public static boolean isDateAfterToday(final String dateStr)
	throws ParseException {
		Date date = DataUtil.toDate(dateStr);
		return isDateAfterToday(date);
	}

	/**
	 * Retorna a data de hoje sem hora.
	 * 
	 * @return hoje ddMMyyyy
	 */
	public static Date today_ddMMyyyy() {
		GregorianCalendar calendario = new GregorianCalendar();
		calendario.setTime(new Date());
		calendario.set(Calendar.HOUR_OF_DAY, 0);
		calendario.set(Calendar.MINUTE, 0);
		calendario.set(Calendar.SECOND, 0);
		calendario.set(Calendar.MILLISECOND, 0);
		return calendario.getTime();
	}

	/**
	 * Atualiza o dia do mês, mês e ano de um objeto Calendar a partir de 
	 * um java.util.Date.
	 * 
	 * @param c
	 * @param date
	 */
	public static void setDate(Calendar c, Date date) {
		Calendar aux = Calendar.getInstance();
		aux.setTime(date);

		c.set(Calendar.DAY_OF_MONTH, aux.get(Calendar.DAY_OF_MONTH));
		c.set(Calendar.MONTH, aux.get(Calendar.MONTH));
		c.set(Calendar.YEAR, aux.get(Calendar.YEAR));
	}

	/**
	 * Atualiza a hora, minuto, segundo e milisegundo de um objeto Calendar
	 * baseado num java.util.Date.
	 * 
	 * @param c
	 * @param time
	 */
	public static void setTime(Calendar c, Date time) {
		Calendar aux = Calendar.getInstance();
		aux.setTime(time);

		c.set(Calendar.HOUR_OF_DAY, aux.get(Calendar.HOUR_OF_DAY));
		c.set(Calendar.MINUTE, aux.get(Calendar.MINUTE));
		c.set(Calendar.SECOND, aux.get(Calendar.SECOND));
		c.set(Calendar.MILLISECOND, aux.get(Calendar.MILLISECOND));
	}

	/**
	 * Atualiza o dia do mês, mês, ano, hora, minuto, segundo e milisegundo
	 * de um objeto Calendar a partir de um Date.
	 * 
	 * @param c
	 * @param date
	 * @param time
	 */
	public static void setDateTime(Calendar c, Date date, Date time) {
		setDate(c, date);
		setTime(c, time);
	}

	/**
	 * Retorna o ano e mês na forma de um Integer no formato yyyyMM.
	 * 
	 * @return
	 */
	public static Integer getActualYearMonth() {
		String text = formatDate(new Date(), "yyyyMM");

		return new Integer(text);
	}

	/**
	 * Retorna um java.sql.Timestamp baseado na data/hora corrente.
	 * 
	 * @return
	 */
	public static Timestamp getActualTimestamp() {
		Date date = new Date();

		return new Timestamp(date.getTime());
	}

	/**
	 * Verifica se a data é fim de semana.
	 * 
	 * @param data
	 * @return
	 */
	public static boolean isDiaUtil(Date data) {
		Calendar c = Calendar.getInstance();
		c.setTime(data);

		int diaSemana = c.get(Calendar.DAY_OF_WEEK);

		return (diaSemana == 1 || diaSemana == 7);

	}


	public static Date getSqlDateComoDate(java.sql.Date date) {
		if (date != null) {
			return new Date(date.getTime());
		} else {
			return null;
		}
	}

	public static java.sql.Date getDateComoSqlDate(Date date) {
		if (date != null) {
			return new java.sql.Date(date.getTime());
		} else {
			return null;
		}
	}

	public static java.sql.Timestamp getDateComoSqlTimestamp(Date date) {
		if (date != null) {
			return new java.sql.Timestamp(date.getTime());
		} else {
			return null;
		}
	}

	public static java.sql.Time getDateComoSqlTime(Date date) {
		if (date != null) {
			return new java.sql.Time(date.getTime());
		} else {
			return null;
		}
	}

	public static String getDataComoString(Date data) {
		return getDataComoString(data, "dd/MM/yyyy");
	}

	public static String getHoraComoString(Date data) {
		return getDataComoString(data, "HH:mm");
	}

	public static String getDataHoraComoString(Date data) {
		return getDataComoString(data, "dd/MM/yyyy hh:mm:ss");
	}

	public static String getHoraCompletaComoString(Date data) {
		return DataUtil.getDataComoString(data, "HH:mm:ss");
	}

	public static String getDataInvertidaComoString(Date date) {
		return getDataComoString(date, "yyyy-MM-dd");
	}

	public static String getDataComoString(Date data, String formatoDaData) {
		if (data == null) {
			return "";
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat(formatoDaData, locale);
		return dateFormat.format(data);
	}

	public static Date getData(String dataString, String formatoDaData) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat(formatoDaData);
		dateFormat.setLenient(false);
		return dateFormat.parse(dataString);
	}

	public static Date getData(String dataString) throws ParseException {
		return getData(dataString, "dd/MM/yyyy");
	}

	public static Date getDataHora(String dataHoraString) throws ParseException {
		return getData(dataHoraString, "dd/MM/yyyy hh:mm:ss");
	}

	public static Date novaData(int ano, int mes, int dia, int hora, int minuto, int segundo) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(ano, mes, dia, hora, minuto, segundo);
		return calendar.getTime();
	}

	/**
	 * @param ano
	 * @param mes (0=janeiro -> 11=dezembro)
	 * @param dia
	 * @return
	 */
	public static Date novaData(int ano, int mes, int dia) {
		return novaData(ano, mes, dia, 0, 0, 0);
	}

	public static Date getHoraZero(Date date) {
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(date);
		int residuoDeMilisegundos = calendario.get(Calendar.MILLISECOND);
		int residuoDeSegundos = calendario.get(Calendar.SECOND) * 1000;
		int residuoDeMinutos = calendario.get(Calendar.MINUTE) * 60000;
		int residuoDeHoras = calendario.get(Calendar.HOUR_OF_DAY) * 3600000;
		int residuoTotal = residuoDeMilisegundos
		+ residuoDeSegundos
		+ residuoDeMinutos
		+ residuoDeHoras;
		long longDate = calendario.getTimeInMillis() - residuoTotal;
		return new Date(longDate);
	}

	public static int millisToDias(long millis) {
		return (int) (millis / MILLIS_DIA);
	}

	public static long diasToMillis(int quantidadeDeDias) {
		return quantidadeDeDias * MILLIS_DIA;
	}

	public static long horasToMillis(int quantidadeDeHoras) {
		return quantidadeDeHoras * MILLIS_DIA;
	}

	public static long minutosToMillis(int quantidadeDeMinutos) {
		return quantidadeDeMinutos * 60000;
	}

	public static long segundosToMillis(int quantidadeDeSegundos) {
		return quantidadeDeSegundos * 1000;
	}

	public static Date somaHoras(Date data, int quantidadeDeHoras) {
		return somaCampo(Calendar.HOUR_OF_DAY, data, quantidadeDeHoras);
	}

	public static Date somaMinutos(Date data, int quantidadeDeMinutos) {
		return somaCampo(Calendar.MINUTE, data, quantidadeDeMinutos);
	}

	public static Date somaMilisegundos(Date data, int quantidadeDeMilisegundos) {
		return somaCampo(Calendar.MILLISECOND, data, quantidadeDeMilisegundos);
	}

	public static Date somaSegundos(Date data, int quantidadeDeSegundos) {
		return somaCampo(Calendar.SECOND, data, quantidadeDeSegundos);
	}

	public static Date somaDias(Date data, int quantidadeDeDias) {
		return somaCampo(Calendar.DAY_OF_MONTH, data, quantidadeDeDias);
	}

	public static Date somaMeses(Date data, int numeroDeMeses) {
		return somaCampo(Calendar.MONTH, data, numeroDeMeses);
	}

	public static Date somaAnos(Date data, int numeroDeAnos) {
		return somaCampo(Calendar.YEAR, data, numeroDeAnos);
	}

	public static Date somaCampo(int campo, Date data, int quantidade) {
		Calendar calendar = getCalendarDaData(data);
		calendar.add(campo, quantidade);
		return calendar.getTime();
	}

	public static int diferencaEmAnos(Date dataA, Date dataB) {
		return (DataUtil.getAno(dataA) - DataUtil.getAno(dataB));
	}

	public static int diferencaEmMeses(Date dataA, Date dataB) {
		int anoA = DataUtil.getAno(dataA);
		int anoB = DataUtil.getAno(dataB);
		int mesA = DataUtil.getMes(dataA);
		int mesB = DataUtil.getMes(dataB);
		if (dataA.before(dataB)) {
			return ((anoB - anoA) * 12 + (mesB - mesA)) * -1;
		} else {
			return (anoA - anoB) * 12 + (mesA - mesB);
		}
	}

	public static int diferencaEmDias(Date dataA, Date dataB) {
		int diferencaTemporaria = 0;
		int diferencaEmDias = 0;
		Calendar menorData = Calendar.getInstance();
		Calendar maiorData = Calendar.getInstance();
		if (dataA.compareTo(dataB) < 0) {
			menorData.setTime(dataA);
			maiorData.setTime(dataB);
		} else {
			menorData.setTime(dataB);
			maiorData.setTime(dataA);
		}
		while (menorData.get(Calendar.YEAR) != maiorData.get(Calendar.YEAR)) {
			diferencaTemporaria = 365 * (maiorData.get(Calendar.YEAR) - menorData.get(Calendar.YEAR));
			diferencaEmDias += diferencaTemporaria;
			menorData.add(Calendar.DAY_OF_YEAR, diferencaTemporaria);
		}
		if (menorData.get(Calendar.DAY_OF_YEAR) != maiorData.get(Calendar.DAY_OF_YEAR)) {
			diferencaTemporaria = maiorData.get(Calendar.DAY_OF_YEAR)
			- menorData.get(Calendar.DAY_OF_YEAR);
			diferencaEmDias += diferencaTemporaria;
			menorData.add(Calendar.DAY_OF_YEAR, diferencaTemporaria);
		}
		return diferencaEmDias;
	}

	public static Date getPrimeiroDoMesAtual() {
		return getCalendarPrimeiroDoMesAtual().getTime();
	}

	public static Calendar getCalendarPrimeiroDoMesAtual() {
		Calendar calendar = getCalendarDeHoje();
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		return zeraCalendar(calendar);
	}

	public static Calendar getCalendarDeHoje() {
		return getCalendarDaData(new Date());
	}

	public static Calendar getCalendarDeHojeHoraZero() {
		Calendar calendar = getCalendarDeHoje();
		return zeraCalendar(calendar);
	}

	public static Calendar zeraCalendar(Calendar calendar) {
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar;
	}

	protected static Calendar getCalendarDaData(Date data) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(data);
		return calendar;
	}

	public static Date subtraiDias(Date date, int quantidadeDeDias) {
		return somaDias(date, -quantidadeDeDias);
	}

	public static int getUltimoDiaDoMes(Date data) {
		Calendar calendar = getCalendarDaData(data);
		return calendar.getActualMaximum(Calendar.DATE);
	}

	public static Date getDataPorFormato(Date data, String formatoDaData){
		Date dataRetorno = null;
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat(formatoDaData);
			dateFormat.setLenient(false);	       
			dataRetorno = dateFormat.parse(dateFormat.format(data));

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataRetorno;
	}


	/**
	 * 
	 * @param data
	 * 
	 * @return -1 caso o parametro data esteja nulo
	 */
	 public static int getAno(Date data) {
		if (data == null) {
			return -1;
		}

		String ano = getDataComoString(data, "yyyy");
		return Integer.parseInt(ano);
	}


	public static int getAnoAtual() {
		return getAno(getDataAtual());
	}

	public static int getMes(Date data) {
		String mes = getDataComoString(data, "MM");
		return Integer.parseInt(mes);
	}

	public static int getDia(Date data) {
		String dia = getDataComoString(data, "dd");
		return Integer.parseInt(dia);
	}

	public static int getHoras(Date data) {
		String dia = getDataComoString(data, "HH");
		return Integer.parseInt(dia);
	}

	public static int getMinutos(Date data) {
		String dia = getDataComoString(data, "mm");
		return Integer.parseInt(dia);
	}

	public static int getSegundos(Date data) {
		String dia = getDataComoString(data, "ss");
		return Integer.parseInt(dia);
	}

	/**
	 * @param data
	 * @return 1 = domingo, 7 = sábado
	 */
	public static int getDiaDaSemana(Date data) {
		return getCalendarDaData(data).get(Calendar.DAY_OF_WEEK);
	}

	public static boolean isMesmoDia(Date dataA, Date dataB) {
		if (dataA != null && dataB != null) {
			Calendar a = Calendar.getInstance();
			a.setTime(dataA);
			Calendar b = Calendar.getInstance();
			b.setTime(dataB);
			return (a.get(Calendar.YEAR) == b.get(Calendar.YEAR)
					&& a.get(Calendar.MONTH) == b.get(Calendar.MONTH) && a.get(Calendar.DAY_OF_MONTH) == b.get(Calendar.DAY_OF_MONTH));
		} else {
			return false;
		}
	}

	/**
	 * @param data
	 *            Data a testar
	 * @param dataInicial
	 *            limite inicial
	 * @param dataFinal
	 *            limite final
	 * 
	 * uma data de limite nula significa infinito, sem limite
	 * @return
	 */
	public static boolean isDataNaFaixa(Date data, Date dataInicial, Date dataFinal) {
		return (dataInicial == null || data.compareTo(dataInicial) >= 0)
		&& (dataFinal == null || data.compareTo(dataFinal) <= 0);
	}

	public static boolean isDataValida(String data) {
		return isDataValida(data, "dd/MM/yyyy");
	}

	public static boolean isDataValida(String data, String formatoDaData) {
		try {
			StringTokenizer tokenizer = new StringTokenizer(data, "/");
			int ano, mes, dia;
			dia = Integer.parseInt(tokenizer.nextToken());
			mes = Integer.parseInt(tokenizer.nextToken());
			ano = Integer.parseInt(tokenizer.nextToken());
			Calendar calendario = new GregorianCalendar();
			SimpleDateFormat formatador = new SimpleDateFormat(formatoDaData);
			java.util.Date resposta = formatador.parse(data);
			calendario.setTime(resposta);
			return (ano == calendario.get(Calendar.YEAR)
					&& mes == calendario.get(Calendar.MONTH) + 1 && dia == calendario.get(Calendar.DATE));
		} catch (Exception e) {
			return false;
		}
	}

	public static Date setDiaDaData(Date data, int dia) {
		Calendar calendar = getCalendarDaData(data);
		try {
			calendar.set(Calendar.DAY_OF_MONTH, dia);
		} catch (ArrayIndexOutOfBoundsException e) {
			return null;
		}
		return calendar.getTime();
	}

	public static Date setMesDaData(Date data, int mes) {
		Calendar calendar = getCalendarDaData(data);
		try {
			calendar.set(Calendar.MONTH, mes - 1);
		} catch (ArrayIndexOutOfBoundsException e) {
			return null;
		}
		return calendar.getTime();
	}

	public static Date setAnoDaData(Date data, int ano) {
		Calendar calendar = getCalendarDaData(data);
		try {
			calendar.set(Calendar.YEAR, ano);
		} catch (ArrayIndexOutOfBoundsException e) {
			return null;
		}
		return calendar.getTime();
	}

	public static Date getDataAtual() {
		return new Date();
	}

	/**
	 * Retorna a data para o formato de documentos <br>
	 * EX.: 05 de Outubro de 2004
	 * 
	 * @param data
	 * @return dd de MMMMM de yyyy
	 */
	public static String getDataPorExtenso(Date data) {
		String o[] = { "de", "de" };
		MessageFormat msg = new MessageFormat(getDataComoString(data, "dd {0} MMMMM {1} yyyy"));
		return msg.format(o);
	}

	public static Date getDataNoUltimoDiaDoMes(Date data) {
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(data);
		calendario.set(Calendar.DAY_OF_MONTH, calendario.getActualMaximum(Calendar.DAY_OF_MONTH));
		return calendario.getTime();
	}

	public static String getMesLiteral(int mes) {
		Date data = null;
		try {
			data = getData("01/01/1970");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		data = setMesDaData(data, mes);
		return getDataComoString(data, "MMMMM");
	}

	public static Time getDateComoTime(Date value) {
		Time time = null;
		if (value != null) {
			time = new Time(value.getTime());
		}
		return time;
	}

	public static int getDiaMaximoDoMes(Date data) {
		Calendar calendar = getCalendarDaData(data);
		return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	/**
	 * @param data
	 * @return
	 */
	public static boolean isHoraRedunda(Date data) {
		return getMinutos(data) == 0;
	}

	/**
	 * @param fim
	 * @param inicio
	 * @return
	 */
	public static long diferencaEmMinutos(Date fim, Date inicio) {
		return (fim.getTime() - inicio.getTime()) / 60000;
	} 

	/**
	 * @param fim
	 * @param inicio
	 * @return
	 */
	public static long diferencaEmHoras(Date fim, Date inicio) {
		return (fim.getTime() - inicio.getTime()) / 3600000;
	} 

	/**
	 * @param dataSelecionada
	 * @return
	 */
	public static Date getDataPrimeiroDiaMesDepois(Date dataSelecionada) {
		return somaDias(getDataNoUltimoDiaDoMes(dataSelecionada), 1);
	}

	public static Date getDateComHoraFinal(Date date) {
		return novaData(getAno(date), getMes(date) - 1, getDia(date), 23, 59, 59);
	}

	/**
	 * Compara datas desprezando a hora
	 * 
	 * @param data1
	 * @param data2
	 * @return valor booleano indicando se os dias informados são o mesmo
	 */
	public static boolean equalsDia(Date data1, Date data2) {
		return diferencaEmDias(data1, data2) == 0;
	}

	public static Date juntaTime(Date data, Date horas) {
		Calendar calendar = getCalendarDaData(data);
		calendar.set(Calendar.HOUR_OF_DAY, DataUtil.getHoras(horas));
		calendar.set(Calendar.MINUTE, DataUtil.getMinutos(horas));
		calendar.set(Calendar.SECOND, DataUtil.getSegundos(horas));
		return calendar.getTime();
	}

	public static String getDiaDaSemanaLiteral(Date data) {
		return getDataComoString(data, "EEEEEEEEEEEEE");
	}

	public static Date getDataAtualSeNula(Date data){
		Date resposta = data;
		if (data == null) {
			resposta = getDataAtual();
		}
		return resposta;
	}

	public static Date getDateDoTimestamp(Timestamp timestamp){
		Date resposta = null;
		if(timestamp != null){
			resposta = new Date(timestamp.getTime());    
		}
		return resposta;
	}

	public static int getHoraMinutosSegundosEmSegundos(Date data) {
		int numeroDeSegundos = getHoras(data)*3600;
		numeroDeSegundos+=getMinutos(data)*60;
		numeroDeSegundos+=getSegundos(data);
		return numeroDeSegundos;
	}

	public static int getIdadeEmAnos(Date dataDeNascimento) {
		return getIdadeEmAnos(dataDeNascimento,getDataAtual());
	}

	public static int getIdadeEmAnos(Date dataDeNascimento, Date dataDeReferencia) {
		int diferencaEmAnos = getAno(dataDeReferencia) - getAno(dataDeNascimento);
		int diferencaEmMeses = getMes(dataDeReferencia) - getMes(dataDeNascimento);
		int diferencaEmDias = getDia(dataDeReferencia) - getDia(dataDeNascimento);
		if (diferencaEmAnos <= 0) {
			return 0;
		} else if (diferencaEmMeses < 0 || (diferencaEmMeses == 0 && diferencaEmDias < 0)) {
			return diferencaEmAnos - 1;
		}
		return diferencaEmAnos;      
	}

	public static boolean isDataNulaOuVazia(Date data) {
		return data == null || data.toString().trim().equals("");
	}


	public static Date getDataHora24(String dataHoraString) throws ParseException {
		return getData(dataHoraString, "dd/MM/yyyy HH:mm:ss");
	}

	///////agendamento///////
	public static Time getHora(Date data) {
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		String hora = getHoraComoString(data) + ":00";
		try {
			return new java.sql.Time(dateFormat.parse(hora).getTime());
		} catch (ParseException e) {
			return null;
		}
	}

	public static Date subtraiCampo(int campo, Date data, int quantidade) {
		Calendar calendar = getCalendarDaData(data);
		quantidade = quantidade*(-1);
		calendar.add(campo, quantidade);
		return calendar.getTime();
	}

	public static Date subtraiMinutos(Date data, int quantidadeDeMinutos) {
		return subtraiCampo(Calendar.MINUTE, data, quantidadeDeMinutos);
	}

	public static Date incrementaDia(Date data) {
		Calendar calendario = getCalendarDaData(data);
		int dia = calendario.get(Calendar.DAY_OF_MONTH);
		calendario.set(Calendar.DAY_OF_MONTH,dia+1);
		return calendario.getTime();
	}

	/**
	 * 
	 * @param horas
	 * @return yyyy ano(s) mm mês(es) dd dia(s)
	 */
	public static String getDataPorExtenso(long horas) {
		String ret = "";
		long dias = horas/24;
		int dia, mes, ano;
		if((ano = (int) (dias / 365)) != 0) {
			ret += ano + " ano(s) ";
			dias -= ano * 365;
		}
		if((mes = (int) dias / 30) != 0) {
			ret += mes + " mês(es) ";
			dias -= mes*30;
		}

		if((dia = (int) dias) > 0) {
			ret += dia + " dia(s) ";
		}
		return ret;
	}

	/**
	 * Verifica se o dia é um dia de final de semana, mas pergunta por dia específico.
	 * 
	 * @param dataAtual
	 * @return boolean
	 */
	public static boolean verificarDiaFinalDeSemana(Date dataAtual, int diaFinalSemana) {
		boolean ret = false;

		Calendar cal = GregorianCalendar.getInstance();

		cal.setTime(dataAtual);

		int diaSemana = cal.get(Calendar.DAY_OF_WEEK);

		if (diaSemana == diaFinalSemana)  {
			ret = true;
		}

		return ret;
	}

	/**
	 * Gera data (String)a partir de um formato.
	 * @param date
	 * @param tipo
	 * @return String
	 */
	public static String gerarDataFormatada(Date date, int tipo) {
		String pat0 = "yyyy-MM-dd HH:mm:ss SSSSSSSSS";
		String pat1 = "dd/MM/yyyy HH:mm:ss";
		String pat2 = "EEE MMM d HH:mm:ss z Z yyyy";
		String pat3 = "ddMMyyyy:HHmmss";
		String pat4 = "EEEEEEEEE, d MMMMMM yyyy";
		String pat6 = "yyyyMMdd";
		String pat7 = "HHmmss";
		String pat8 = "dd.MM.yyyy";
		String pat9 = "dd/MM/yyyy";
		String pat10 = "yyyyMM";
		String pat11 = "MM/yyyy";
		String pat12 = "MM";
		String pat13 = "yyyy";
		String pat14 = "dd de MM de yyyy";
		String data = "";
		boolean bTemData = true;

		SimpleDateFormat simpleDateFormat = null;

		if (date == null) {
			date = new Date();
		}

		if (tipo == 0) {
			simpleDateFormat = new SimpleDateFormat(pat0);
		} else if (tipo == 1) {
			simpleDateFormat = new SimpleDateFormat(pat1);
		} else if (tipo == 2) {
			simpleDateFormat = new SimpleDateFormat(pat2);
		} else if (tipo == 3) {
			simpleDateFormat = new SimpleDateFormat(pat3);
		} else if (tipo == 4) {
			simpleDateFormat = new SimpleDateFormat(pat4);
		} else if (tipo == 6) {
			simpleDateFormat = new SimpleDateFormat(pat6);
		} else if (tipo == 7) {
			simpleDateFormat = new SimpleDateFormat(pat7);
		} else if (tipo == 8) {
			simpleDateFormat = new SimpleDateFormat(pat8);
		} else if (tipo == 9) {
			simpleDateFormat = new SimpleDateFormat(pat9);
		} else if (tipo == 10) {
			simpleDateFormat = new SimpleDateFormat(pat10);
		} else if (tipo == 11) {
			simpleDateFormat = new SimpleDateFormat(pat11);
		} else if(tipo == 12) {
			simpleDateFormat = new SimpleDateFormat(pat12);
		} else if(tipo == 13) {
			simpleDateFormat = new SimpleDateFormat(pat13);
		} else if(tipo == 14) {
			simpleDateFormat = new SimpleDateFormat(pat14);
		}

		if (bTemData) {
			data = simpleDateFormat.format(date);
		}

		return data;
	}
	
	/**
	 * Método para converter um int mês entre 0 e 11 em uma String mês por extenso.
	 * 
	 * @param iMes
	 * @return String
	 */
	public static String converterMesParaExtenso(int iMes) {
		String mes = "";

		switch (iMes) {
		case 0:
			mes = "Janeiro";
			break;

		case 1:
			mes = "Fevereiro";
			break;

		case 2:
			mes = "Março";
			break;

		case 3:
			mes = "Abril";
			break;

		case 4:
			mes = "Maio";
			break;

		case 5:
			mes = "Junho";
			break;

		case 6:
			mes = "Julho";
			break;

		case 7:
			mes = "Agosto";	
			break;

		case 8:
			mes = "Setembro";
			break;

		case 9:
			mes = "Outubro";
			break;

		case 10:
			mes = "Novembro";
			break;

		case 11:
			mes = "Dezembro";	
			break;	
			
		default:
			mes = "Informe um mês valido! Valor entre 0 a 11!";
		}
		
		return mes;
	}
	
	/**
	 * Método para converter um int mês entre 0 e 11 em uma String mês por extenso.
	 * 
	 * @param iMes
	 * @return String
	 */
	public static String converterMesParaExtensoAbreviado(int iMes) {
		String mes = "";

		switch (iMes) {
		case 0:
			mes = "Jan";
			break;

		case 1:
			mes = "Fev";
			break;

		case 2:
			mes = "Mar";
			break;

		case 3:
			mes = "Abr";
			break;

		case 4:
			mes = "Mai";
			break;

		case 5:
			mes = "Jun";
			break;

		case 6:
			mes = "Jul";
			break;

		case 7:
			mes = "Ago";	
			break;

		case 8:
			mes = "Set";
			break;

		case 9:
			mes = "Out";
			break;

		case 10:
			mes = "Nov";
			break;

		case 11:
			mes = "Dez";	
			break;	
			
		default:
			mes = "Informe um mês valido! Valor entre 0 a 11!";
		}
		
		return mes;
	}

}