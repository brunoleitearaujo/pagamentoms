package com.baraujo.pagamentoms.config;

import com.baraujo.pagamentoms.entity.TipoCarteira;
import com.baraujo.pagamentoms.repository.TipoCarteiraRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DataLoader implements CommandLineRunner{

    private final TipoCarteiraRepository repository;

    public DataLoader(TipoCarteiraRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        Arrays.stream(TipoCarteira.Tipo.values())
                .forEach(tipo -> repository.save(tipo.get()));
    }
}
