/**
 * LY.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package zhangyuyao.json;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author zyy43688
 * @version $Id: DemoJson.java, v 0.1 2018年6月1日 上午10:23:12 zyy43688 Exp $
 */
public class DemoJson {
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(JsonDemo.data);

        if (rootNode.isObject()) {
            process(rootNode);
        } else if (rootNode.isArray()) {
            processArray(rootNode);
        }

        System.out.println(sb.toString());
    }

    private static void processArray(JsonNode rootNode) {
        rootNode.fields().forEachRemaining(e -> {
            System.out.println(e.getKey());
            System.out.println(e.getValue());
        });

        sb.append("[");

        AtomicInteger i = new AtomicInteger(0);
        rootNode.elements().forEachRemaining((e) -> {
            if (i.get() >= 1) {
                sb.append(",");
            }
            process(e);
            i.incrementAndGet();
        });

        sb.append("]");
    }

    private static void process(JsonNode jsonNode) {
        if (jsonNode.isObject()) {

            Iterator<Map.Entry<String, JsonNode>> iterator = jsonNode.fields();

            List<Map.Entry<String, JsonNode>> entries = new ArrayList<>();

            // 取出数据
            while (iterator.hasNext()) {

                Map.Entry<String, JsonNode> entry = iterator.next();
                entries.add(entry);
            }

            // 排序数据
            entries.sort(Comparator.comparing(Map.Entry::getKey));

            String template = "\"%s\":%s";
            String template2 = "\"%s\":";

            sb.append("{");

            int i = 0;

            for (Map.Entry<String, JsonNode> entry : entries) {

                if (entry.getValue().isObject()) {
                    if (i >= 1) {
                        sb.append(",");
                    }
                    sb.append(String.format(template2, entry.getKey()));
                    process(entry.getValue());
                    i++;
                } else {
                    if (i >= 1) {
                        sb.append(",");
                    }
                    sb.append(String.format(template, entry.getKey(), entry.getValue()));
                    i++;
                }

            }

            sb.append("}");

        } else if (jsonNode.isArray()) {
            System.out.println(jsonNode.asText());
        } else {
            throw new RuntimeException("未知的解析类型");
        }
    }
}