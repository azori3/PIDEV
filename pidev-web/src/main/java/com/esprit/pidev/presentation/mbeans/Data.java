package com.esprit.pidev.presentation.mbeans;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.esprit.pidev.entity.Contrat;
import com.esprit.pidev.entity.SecteurActivite;

@ManagedBean
@ApplicationScoped
public class Data {
	
public SecteurActivite[] getActivites()
{
	return SecteurActivite.values();
}

public Contrat[] getContrats()
{
	return Contrat.values();
}	
public Data() {
	// TODO Auto-generated constructor stub
}

}
