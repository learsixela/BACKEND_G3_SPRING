package com.everis.data.manager;

import java.util.List;

import com.everis.data.models.Cuenta;

public interface CuentaManager {

	public Cuenta findBiId(Long id);
	public List<Cuenta> getAll();
	public void save(Cuenta cuenta);
}
