package com.example.demo.dao;

import com.example.demo.FirestoreInitializer;
import com.example.demo.dto.SpecimenDto;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class SpecimenDao implements ISpecimenDao {


    private final String USERS = "Users";
    private Firestore firestore;
    @Autowired
    SpecimenRepository specimenRepository;

    public SpecimenDao(final FirestoreInitializer firestoreInitializer) {
        firestore=firestoreInitializer.getDb();

    }

    @Override
    public boolean save(SpecimenDto specimenDTO) throws Exception {
        ApiFuture<WriteResult> future = firestore.collection(USERS).document("email").set(specimenDTO);
        if (Objects.isNull(future.get().getUpdateTime())) {
            return false;
        }
        return true;
    }


    @Override
    public SpecimenDto findById(String id)throws Exception{
        CollectionReference
                collectionReference = firestore.collection(USERS);
        ApiFuture<QuerySnapshot> future = collectionReference.get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        if (Objects.isNull(documents) || documents.size()==0) {
            return null;
        } else {
            return documents.get(0).toObject(SpecimenDto.class);
        }
    }

    @Override
    public boolean existsById(String id) throws Exception {
        CollectionReference
                collectionReference = firestore.collection(USERS);
        ApiFuture<QuerySnapshot> future = collectionReference.get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        if (Objects.isNull(documents) || documents.size()==0) {
            return false;
        } else {
            return true;
        }
    }
}
