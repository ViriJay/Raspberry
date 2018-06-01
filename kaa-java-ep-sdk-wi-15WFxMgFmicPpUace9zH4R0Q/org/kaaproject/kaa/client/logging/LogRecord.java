/*
 * Copyright 2014-2016 CyberVision, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.kaaproject.kaa.client.logging;

import java.io.IOException;

import org.kaaproject.kaa.common.avro.AvroByteArrayConverter;

/**
 * This class is auto-generated. Do not change it.
 *
 * Wrapper class to encapsulate Avro-generated log record. 
 * Use it for log collecting.
 */
public class LogRecord {
    /**
     * Thread-local converter of log records to bytes.
     */
    private static final ThreadLocal<AvroByteArrayConverter<org.kaaproject.kaa.schema.sample.DataCollection>> CONVERTER = new ThreadLocal<AvroByteArrayConverter<org.kaaproject.kaa.schema.sample.DataCollection>>(){
        @Override
        protected AvroByteArrayConverter<org.kaaproject.kaa.schema.sample.DataCollection> initialValue() {
            return new AvroByteArrayConverter<>(org.kaaproject.kaa.schema.sample.DataCollection.class);
        }
    };

    /**
     * Avro-encoded log record.
     */
    private final byte [] encodedRecord;
    
    public LogRecord(org.kaaproject.kaa.schema.sample.DataCollection record) throws IOException {
        encodedRecord = CONVERTER.get().toByteArray(record);
    }

    LogRecord(byte [] avroEncodedRecord) {
        encodedRecord = avroEncodedRecord;
    }

    byte [] getData() {
        return encodedRecord;
    }

    public long getSize() {
        return encodedRecord.length;
    }
}
