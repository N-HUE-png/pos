package com.iiuc.transportation.service;

import com.iiuc.transportation.model.Model;
import java.util.ArrayList;
import java.util.List;

public class ModelService {

    private List<Model> busList = new ArrayList<>();

    // Add Bus
    public void addBus(Model model) {
        busList.add(model);
        System.out.println("Bus added successfully.");
    }

    // Get All Buses
    public List<Model> getAllBuses() {
        return busList;
    }

    // Find Bus By ID
    public Model getBusById(Long id) {

        for (Model model : busList) {
            if (model.getId().equals(id)) {
                return model;
            }
        }

        return null;
    }

    // Update Bus
    public boolean updateBus(Long id, Model updatedModel) {

        for (int i = 0; i < busList.size(); i++) {

            if (busList.get(i).getId().equals(id)) {

                busList.set(i, updatedModel);

                return true;
            }
        }

        return false;
    }

    // Delete Bus
    public boolean deleteBus(Long id) {

        for (Model model : busList) {

            if (model.getId().equals(id)) {

                busList.remove(model);

                return true;
            }
        }

        return false;
    }

    // Search Bus By Route Name
    public List<Model> searchByRoute(String routeName) {

        List<Model> result = new ArrayList<>();

        for (Model model : busList) {

            if (model.getRouteName().equalsIgnoreCase(routeName)) {

                result.add(model);
            }
        }

        return result;
    }

    // Search Bus By Semester
    public List<Model> searchBySemester(String semester) {

        List<Model> result = new ArrayList<>();

        for (Model model : busList) {

            if (model.getSemester().equalsIgnoreCase(semester)) {

                result.add(model);
            }
        }

        return result;
    }
}
