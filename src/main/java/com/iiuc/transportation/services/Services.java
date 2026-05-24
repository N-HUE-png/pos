package com.iiuc.transportation.service;

import com.iiuc.transportation.model.Model;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ModelService {

    // Store all buses
    private final List<Model> busList = new ArrayList<>();

    // Add Bus
    public void addBus(Model model) {
        if (model != null) {
            busList.add(model);
            System.out.println("Bus added successfully.");
        }
    }

    // Get All Buses
    public List<Model> getAllBuses() {
        // Returning a new copy prevents external code from modifying your internal list directly
        return new ArrayList<>(busList);
    }

    // Find Bus By ID
    public Model getBusById(Long id) {
        if (id == null) return null;

        for (Model model : busList) {
            // Objects.equals handles null variables safely without throwing an exception
            if (Objects.equals(model.getId(), id)) {
                return model;
            }
        }
        return null;
    }

    // Update Bus
    public boolean updateBus(Long id, Model updatedModel) {
        if (id == null || updatedModel == null) return false;

        for (int i = 0; i < busList.size(); i++) {
            if (Objects.equals(busList.get(i).getId(), id)) {
                // Keep same ID
                updatedModel.setId(id);
                busList.set(i, updatedModel);
                return true;
            }
        }
        return false;
    }

    // Delete Bus
    public boolean deleteBus(Long id) {
        if (id == null) return false;

        for (int i = 0; i < busList.size(); i++) {
            if (Objects.equals(busList.get(i).getId(), id)) {
                busList.remove(i);
                return true;
            }
        }
        return false;
    }

    // Search Bus By Route Name
    public List<Model> searchByRoute(String routeName) {
        List<Model> result = new ArrayList<>();
        if (routeName == null) return result;

        for (Model model : busList) {
            // Check that the bus actually has a route assigned before comparing
            if (model.getRouteName() != null && model.getRouteName().equalsIgnoreCase(routeName)) {
                result.add(model);
            }
        }
        return result;
    }

    // Search Bus By Semester
    public List<Model> searchBySemester(String semester) {
        List<Model> result = new ArrayList<>();
        if (semester == null) return result;

        for (Model model : busList) {
            // Check that the bus actually has a semester assigned before comparing
            if (model.getSemester() != null && model.getSemester().equalsIgnoreCase(semester)) {
                result.add(model);
            }
        }
        return result;
    }

    // Search Bus By Bus Number
    public Model searchByBusNumber(String busNumber) {
        if (busNumber == null) return null;

        for (Model model : busList) {
            if (model.getBusNumber() != null && model.getBusNumber().equalsIgnoreCase(busNumber)) {
                return model;
            }
        }
        return null;
    }

    // Display Total Buses
    public int totalBuses() {
        return busList.size();
    }
}
