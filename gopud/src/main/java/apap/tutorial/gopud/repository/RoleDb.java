package apap.tutorial.gopud.repository;

import apap.tutorial.gopud.model.RoleModel;

import java.util.List;

public interface RoleDb {
    List<RoleModel> findAll();
}