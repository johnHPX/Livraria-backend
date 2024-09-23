package util;

import java.sql.*;
import java.time.format.DateTimeParseException;

public class TratarErros {

    public static void tratamentoDeErroBancoDeDados(Exception exception) throws TratamentoException {
        if (exception instanceof ClassNotFoundException){
            throw new TratamentoException("Driver JDBC não encontrado: ", exception);
        } else if (exception instanceof SQLTimeoutException) {
            throw new TratamentoException("Operação excedeu o tempo de espera no banco de dados: ", exception);
        } else if (exception instanceof SQLSyntaxErrorException) {
            throw new TratamentoException("A sintaxe do comando SQL está errada: ", exception);
        } else if (exception instanceof SQLIntegrityConstraintViolationException) {
            throw new TratamentoException("Violação de integridade no banco de dados: ", exception);
        } else if (exception instanceof SQLDataException) {
            throw new TratamentoException("Problemas ao inserir valores: ", exception);
        } else if (exception instanceof SQLException) {
            throw new TratamentoException("Erro não identificado de SQL: ", exception);
        } else {
            throw new TratamentoException("Erro desconhecido: ", exception);
        }
    }

    public static void tratamentoDeConversaoDeTipos(Exception exception) throws TratamentoException {
        if (exception instanceof NullPointerException) {
            throw new TratamentoException("Valor nulo: ", exception);
        } else if (exception instanceof DateTimeParseException) {
            throw new TratamentoException("Data inválida: ", exception);
        } else if (exception instanceof IllegalArgumentException) {
            throw new TratamentoException("Valor passado inválido: ", exception);
        } else {
            throw new TratamentoException("Erro inesperado: ", exception);
        }
    }

}
