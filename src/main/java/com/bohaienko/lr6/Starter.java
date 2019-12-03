package com.bohaienko.lr6;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import weka.associations.Apriori;
import weka.core.Instances;

import java.io.BufferedReader;
import java.io.FileReader;

@Service
public class Starter {

	private Apriori aprioriModel;

	@EventListener(ApplicationReadyEvent.class)
	public void init() throws Exception {
		String file = "src/main/resources/tic-tac-toe_binary.arff";
		Instances instances = new Instances(new BufferedReader(new FileReader(file)));
		aprioriModel = new Apriori();
		aprioriModel.setNumRules(20);
		aprioriModel.buildAssociations(instances);
		System.out.println(aprioriModel);
	}
}
