package repository;

import model.Feature;
import repository.exception.InvalidIdInRepoException;

import java.util.HashMap;
import java.util.Map;

public class FeatureObjectRepository implements ObjectRepository<String, Feature> {
    Map<String, Feature> featureMap= new HashMap<>();
    @Override
    public void add(String featureId, Feature feature) {
        featureMap.put(featureId, feature);
    }

    @Override
    public Feature get(String featureId) {
        if (featureMap.containsKey(featureId)) {
            var feature = featureMap.get(featureId);
            return feature;
        }
        throw new InvalidIdInRepoException();
    }
}
