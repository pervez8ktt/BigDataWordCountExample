package com.knitkota.bigdata.wordcount;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MapperClass extends Mapper<LongWritable, Text, Text, LongWritable> {

	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, LongWritable>.Context context)
			throws IOException, InterruptedException {

		try {

			String str = value.toString();

			if (!str.isEmpty()) {

				String[] words = str.split("\\s+");

				for (String word : words) {
					context.write(new Text(word), new LongWritable(1));
				}

			}

		} catch (Exception e) {

		}

	}

}
