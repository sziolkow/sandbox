package com.github.sziolkow.recommender.itemrecommender;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.common.LongPrimitiveIterator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.LogLikelihoodSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;

/**
 * The program use the rating file structured as follow:
 * user_id, item_id, rating
 * @author slawek
 *
 */
public class ItemRecommender {
	
	public static void main(String[] arg) {
		try {
			DataModel dataModel = new FileDataModel(new File("data/movies.csv"));
			ItemSimilarity sim = new LogLikelihoodSimilarity(dataModel);
			GenericItemBasedRecommender recomender = new GenericItemBasedRecommender(dataModel,  sim);
			long counter = 0;
			for(LongPrimitiveIterator items = dataModel.getItemIDs(); items.hasNext();) {
				long itemId = items.nextLong();
				List<RecommendedItem>recomendations = recomender.mostSimilarItems(itemId, 5);
				
				for(RecommendedItem item:recomendations ) {
					System.out.println(itemId + ", " + item.getItemID() + ", " + item.getValue() );
				}
				
				counter ++;
				if(counter == 10) {
					break;
				}
			}
		} catch (IOException e) {
			System.out.println("There was an error");
			e.printStackTrace();
		} catch (TasteException e) {
			System.out.println("There was a Taste error");
			e.printStackTrace();
		}
	}

}
