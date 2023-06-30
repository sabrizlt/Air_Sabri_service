package com.epicode.airSabri.security.payload;

import java.util.Set;

import com.epicode.airSabri.enumerated.EBagagli;
import com.epicode.airSabri.models.MyUser;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BigliettoDTO {
	    private String username;
	    private String dataAndata;
	    private String dataRitorno;
	    private String partenza;
	    private String arrivo;
	    private EBagagli bagagli;
	    private String numeroBiglietto;
}
