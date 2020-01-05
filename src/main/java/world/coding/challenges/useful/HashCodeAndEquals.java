package world.coding.challenges.useful;

import java.time.LocalDate;
import java.util.*;


/**
 * With respect to implementing equals and hashCode, the simplest case is to
 * simply never use primitive fields or array fields.
 * <p>
 * If a significant field is an array, then equals and hashCode need to process each
 * element of the array. For this reason, it's simpler to use a Collection
 * instead of an array.
 */

public class HashCodeAndEquals {

    /**
     * Possible features of an apartment building.
     */
    enum Feature {
        AIR_COND, CENTRAL_VAC, INDOOR_PARKING
    }

    /**
     * Constructor.
     *
     * @param name              possibly empty
     * @param isDecrepit        never null
     * @param options           never null, possibly empty
     * @param maintenanceChecks never null, possibly empty
     * @param features          never null, possibly empty; callers typically use EnumSet.of().
     * @param numApartments     nullable
     * @param numTenants        nullable
     */
    public HashCodeAndEquals(
        String name,
        Boolean isDecrepit,
        Set<String> options,
        List<LocalDate> maintenanceChecks,
        Set<Feature> features,
        Integer numApartments,
        Long numTenants
    ) {
        this.name = Objects.requireNonNull(name);
        this.isDecrepit = Objects.requireNonNull(isDecrepit);
        this.options = Objects.requireNonNull(options);
        this.maintenanceChecks = Objects.requireNonNull(maintenanceChecks);
        this.features = Objects.requireNonNull(features);
        this.numApartments = numApartments;
        this.numTenants = numTenants;
    }

    @Override
    public boolean equals(Object aThat) {
        //a standard implementation pattern
        //only the type 'HashCodeAndEquals' changes
        if (this == aThat) return true;
        if (!(aThat instanceof HashCodeAndEquals)) return false;
        HashCodeAndEquals that = (HashCodeAndEquals) aThat;
        for (int i = 0; i < this.getSigFields().length; ++i) {
            if (!Objects.equals(this.getSigFields()[i], that.getSigFields()[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        //simple one-line implementation
        return Objects.hash(getSigFields());
    }

    /**
     * For debugging only.
     */
    @Override
    public String toString() {
        return "'" + name + "'";
    }

    //..elided..

    // PRIVATE

    //no primitives, and no arrays!
    private String name;
    private Boolean isDecrepit;
    private Set<String> options;
    private List<LocalDate> maintenanceChecks;
    private Set<Feature> features;
    private Integer numApartments;
    private Long numTenants;

    /**
     * Must be called by BOTH equals and hashCode.
     * 'sig' as in 'significant'.
     * <p>
     * It helps a bit to put the most significant items first, such that
     * the equals method can return as soon as possible, by finding
     * unequal items rapidly.
     */
    private Object[] getSigFields() {
        Object[] result = {
            name, isDecrepit, options, maintenanceChecks,
            features, numApartments, numTenants
        };
        return result;
    }
}
