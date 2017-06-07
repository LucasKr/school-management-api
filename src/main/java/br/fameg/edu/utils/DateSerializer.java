package br.fameg.edu.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateSerializer extends JsonSerializer<Date> {

    public static final SimpleDateFormat FORMATTER = new SimpleDateFormat("dd-MM-yyyy");
    public static final Locale LOCALE = Locale.getDefault();
    public static final TimeZone LOCAL_TIME_ZONE = TimeZone.getDefault();

    @Override
    public void serialize(Date value, JsonGenerator gen, SerializerProvider arg2)
            throws IOException, JsonProcessingException {
        if (value == null) {
            gen.writeNull();
        } else {
            gen.writeString(FORMATTER.format(value.getTime()));
        }
    }
}