package com.example.demo.dao;

import com.example.demo.FirestoreInitializer;
import com.example.demo.dto.SpecimenDto;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component
public class SpecimenDao implements ISpecimenDao {

    private final String USERS="Users";
    private Firestore firestoredb;

    @Autowired
    public SpecimenDao(final FirestoreInitializer firestoreInitializer){
        firestoredb=firestoreInitializer.getDb();
    }


    @Autowired
    SpecimenRepository specimenRepository;


    @Override
    public boolean save(SpecimenDto specimenDTO) throws Exception {
        ApiFuture<WriteResult> future=firestoredb.collection(USERS).document("email").set(specimenDTO);
        if(Objects.isNull(future.get().getUpdateTime())){
            return false;
        }
        return true;
    }


    @Override
    public Optional<SpecimenDto> findById(String id)throws Exception{
        DocumentReference documentReference=firestoredb.collection(USERS).document(id);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        Optional<SpecimenDto> res=Optional.ofNullable(document.toObject(SpecimenDto.class));
        return res;
    }

    @Override
    public boolean existsById(String id) throws Exception {
        DocumentReference documentReference=firestoredb.collection(USERS).document(id);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        return document.exists();
    }
}
