package com.lecturador.android.comunicacion;

import org.kobjects.isodate.IsoDate;
import org.ksoap2.serialization.Marshal;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import java.io.IOException;
import java.sql.Date;

/**
 * Created by Dario Pardo on 7/1/2017.
 */
public class MarshalDatetime implements Marshal {
    @Override
    public Object readInstance(XmlPullParser parser, String s, String s1, PropertyInfo propertyInfo) throws IOException, XmlPullParserException {
       // return Date.valueOf(xmlPullParser.nextText());
        return IsoDate.stringToDate(parser.nextText(), IsoDate.DATE_TIME);
    }

    @Override
    public void writeInstance(XmlSerializer writer, Object o) throws IOException {
        writer.text(IsoDate.dateToString((Date) o, IsoDate.DATE_TIME));
    }

    @Override
    public void register(SoapSerializationEnvelope cm) {
        cm.addMapping(cm.xsd, "dateTime", Date.class, this);
    }
}
