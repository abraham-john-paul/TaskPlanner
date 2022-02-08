package repository;

import model.Epic;
import repository.exception.InvalidIdInRepoException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FeatureToEpicMappingObjectMappingRepository implements ObjectMappingRepository<String, Epic> {
    private final Map<String, List<Epic>> featureEpicMap = new HashMap<>();

    @Override
    public void add(String featureId, Epic epic) {
        if (featureEpicMap.containsKey(featureId) == false) {
            featureEpicMap.put(featureId, new ArrayList<>());
        }
        var epics = featureEpicMap.get(featureId);
        epics.add(epic);
    }

    @Override
    public List<Epic> getAll(String featureId) {
        if (featureEpicMap.containsKey(featureId)) {
            var epics = featureEpicMap.get(featureId);
            return epics;
        }
        throw new InvalidIdInRepoException();
    }
}
