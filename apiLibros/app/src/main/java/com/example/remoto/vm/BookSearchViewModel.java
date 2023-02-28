package com.example.remoto.vm;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.remoto.info.VolumesResponse;
import com.example.remoto.servicioYrepositorio.RepositorioDeLibros;

public class BookSearchViewModel extends AndroidViewModel {
    private RepositorioDeLibros repositorioDeLibros;
    private LiveData<VolumesResponse> volumesResponseLiveData;

    public BookSearchViewModel(@NonNull Application application) {
        super(application);
    }

    public void init() {
        repositorioDeLibros = new RepositorioDeLibros();
        volumesResponseLiveData = repositorioDeLibros.getVolumesResponseLiveData();
    }

    public void searchVolumes(String keyword, String author, String totalItems) {
        repositorioDeLibros.searchVolumes(keyword, author, totalItems);
    }

    public LiveData<VolumesResponse> getVolumesResponseLiveData() {
        return volumesResponseLiveData;
    }
}