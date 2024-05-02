package com.agenda_service_back;

import com.agenda_service_back.agendamento.AgendamentoMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public AgendamentoMapper agendamentoMapper() {
        return Mappers.getMapper(AgendamentoMapper.class); // Use MapStruct's Mappers.getMapper() to create the mapper
    }
    // Other configuration beans can be defined here
}

