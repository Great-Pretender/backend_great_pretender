package com.greatpretender.api.projetoapijaia.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.greatpretender.api.projetoapijaia.entity.UsuarioCargo;

@Configuration
public class RoleUtils {
    
    public List<SimpleGrantedAuthority> ListCargo(String usuarioCargo){
        List<SimpleGrantedAuthority> res = new ArrayList<SimpleGrantedAuthority>();
        res.add(new SimpleGrantedAuthority(usuarioCargo));
        return res;
    }
}
