package com.sncf.cad.model.location;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import javax.validation.constraints.Pattern;

/**
 * @author frederic_boulet Freely inspired from
 *         https://developer.android.com/reference/android/location/Location.html and
 *         https://developer.apple.com/reference/corelocation/cllocation
 */
@Data
public class Location {

    /**
     * Get the longitude, in degrees.
     */
    @NotNull
    private Double longitude;
    /**
     * Get the latitude, in degrees.
     */
    @NotNull
    private Double latitude;

    /**
     * Get the estimated accuracy of this location, in meters.
     */
    private Float accuracy;

    /**
     * Get the altitude if available, in meters above the WGS 84 reference
     * ellipsoid.
     */
    private Double altitude;

    /**
     * Get the UTC time of this fix
     */
    @NotNull
    private ZonedDateTime timestamp;

    /**
     * Get the speed if it is available, in meters/second over ground.
     */
    private Float speed;

    /**
     * Get the type of location for iOS (VISIT_DEPARTURE, VISIT_ARRIVAL, SIGNIFICANT_CHANGE)
     */
    private LocationType type;

    /**
     * UIC of the station, if any
     */
    @Pattern(regexp = ("(^[0-9]{8}|null)$"))
    @JsonIgnoreProperties(value="uic", allowGetters = true, allowSetters = false)
    private String uic;

}
