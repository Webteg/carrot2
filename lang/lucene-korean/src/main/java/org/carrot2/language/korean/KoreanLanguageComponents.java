/*
 * Carrot2 project.
 *
 * Copyright (C) 2002-2019, Dawid Weiss, Stanisław Osiński.
 * All rights reserved.
 *
 * Refer to the full license file "carrot2.LICENSE"
 * in the root folder of the repository checkout or at:
 * https://www.carrot2.org/carrot2.LICENSE
 */
package org.carrot2.language.korean;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.lucene.analysis.ko.KoreanAnalyzer;
import org.carrot2.language.LanguageComponentsProviderImpl;
import org.carrot2.language.LexicalData;
import org.carrot2.language.Stemmer;
import org.carrot2.language.Tokenizer;
import org.carrot2.language.extras.LuceneAnalyzerTokenizerAdapter;
import org.carrot2.text.preprocessing.LabelFormatter;
import org.carrot2.text.preprocessing.LabelFormatterImpl;
import org.carrot2.util.ResourceLookup;

/** */
public class KoreanLanguageComponents extends LanguageComponentsProviderImpl {
  public static final String NAME = "Korean";

  public KoreanLanguageComponents() {
    super("Carrot2 (Korean)", NAME);
  }

  @Override
  public Map<Class<?>, Supplier<?>> load(String language, ResourceLookup resourceLookup)
      throws IOException {
    LexicalData lexicalData = loadLexicalData(NAME, resourceLookup);

    LinkedHashMap<Class<?>, Supplier<?>> components = new LinkedHashMap<>();
    components.put(Stemmer.class, (Supplier<Stemmer>) (() -> (word) -> null));
    components.put(Tokenizer.class, () -> new LuceneAnalyzerTokenizerAdapter(new KoreanAnalyzer()));
    components.put(LexicalData.class, () -> lexicalData);
    components.put(LabelFormatter.class, () -> new LabelFormatterImpl(" "));

    return components;
  }
}
