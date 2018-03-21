package com.aj.service.news.service;

import com.alibaba.fastjson.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Random;

class BaseService {

    private static final long _TIME_SCALE_LONG = 100000000L;
    private static final long _RANDOM_LENGTH_LONG = 5L;
    private static final String _BEGIN_DATETIME = "2018-03-14";
    private static HashMap<Long, Long> _DICT_LONG = new HashMap();
    private static long _LAST_END_DATETIME_TICKS_LONG;
    private static Random random;

    //json
    JSONObject json = new JSONObject();

    //log4j
    Logger logger = LogManager.getLogger();

    //序列化号
    private static final long serialVersionUID = 6357869213649815392L;

    protected static long getLongID() {
        Calendar calendar = Calendar.getInstance();

        try {
            calendar.setTime((new SimpleDateFormat("yyyy-MM-dd")).parse("2016-09-08"));
        } catch (Exception var14) {
            var14.printStackTrace();
        }

        Long curentTicks = Calendar.getInstance().getTimeInMillis();
        Long beginTicks = calendar.getTimeInMillis();
        long timeStamp = (curentTicks - beginTicks) / 100000000L;
        if (timeStamp != _LAST_END_DATETIME_TICKS_LONG) {
            _DICT_LONG.clear();
        }

        long power = (long)Math.pow(10.0D, 5.0D);
        long rand = getRandomLong(5L);
        long result = timeStamp * power + rand;
        if (_DICT_LONG.containsKey(result)) {
            boolean isRepeat = true;

            for(long i = 0L; i < power; ++i) {
                rand = getRandomLong(5L);
                result = timeStamp * power + rand;
                if (!_DICT_LONG.containsKey(result)) {
                    _DICT_LONG.put(result, result);
                    isRepeat = false;
                    break;
                }
            }

            if (isRepeat) {
                return 0L;
            }
        } else {
            _DICT_LONG.put(result, result);
        }

        _LAST_END_DATETIME_TICKS_LONG = timeStamp;
        return result;
    }

    private static long getRandomLong(long length) {
        if (random == null) {
            random = new Random();
        }

        long min = 0L;
        int max = (int)Math.pow(10.0D, (double)length);
        return Long.valueOf((long)random.nextInt(max));
    }
}
