package com.vemser.rest.data.factory;

import com.vemser.rest.model.Usuario;
import net.datafaker.Faker;
import org.apache.commons.lang3.StringUtils;

import java.util.Locale;
import java.util.Random;

public class UsuarioDataFactory {

    private static  Faker faker = new Faker(new Locale("PT-BR"));
    private static Random geradorBoolean = new Random();

    public static Usuario usuarioValido(){
        return novoUsuario();
    }

    public static Usuario usuarioIsAdmin(){
        Usuario usuario = novoUsuario();
        usuario.setAdministrador("true");

        return usuario;
    }

    public static Usuario usuarioComNomeEmBranco(){
        Usuario usuario = novoUsuario();
        usuario.setNome(StringUtils.EMPTY);


        return usuario;

    }


    private static Usuario novoUsuario(){

        Usuario usuario = new Usuario();
        usuario.setNome(faker.name().firstName() + " " + faker.name().lastName());
        usuario.setEmail(faker.internet().emailAddress());
        usuario.setPassword(faker.internet().password());
        usuario.setAdministrador(String.valueOf(geradorBoolean.nextBoolean()));

        return usuario;
    }
}
