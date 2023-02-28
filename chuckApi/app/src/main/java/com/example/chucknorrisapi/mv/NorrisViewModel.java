package com.example.chucknorrisapi.mv;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.chucknorrisapi.data.Info;
import com.example.chucknorrisapi.servicioYresponse.NorrisRepositorio;

public class NorrisViewModel extends AndroidViewModel {
    public NorrisRepositorio repositorio;
    public MutableLiveData<Info> infoMLD;
    public NorrisViewModel(@NonNull Application application) {super(application);}
    public void init() {
        repositorio = NorrisRepositorio.getInstance();
        infoMLD = repositorio.getInfoMLD();
    }
    public void obtenerJoke() {
        repositorio.obtenerJoke();
    }
    public MutableLiveData<Info> getJokeMLD() {
        return infoMLD;
    }
}
