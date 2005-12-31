/**
 * 
 * @author chilang
 * Created 2003-12-29, 18:53:11.
 */
package com.chilang.carrot.filter.cluster.rough;

import java.text.NumberFormat;
import java.util.Locale;

import org.dom4j.DocumentFactory;
import org.dom4j.Element;

import com.chilang.carrot.filter.cluster.rough.clustering.XCluster;


/**
 * Wrapper for clustering results (collection of clusters)
 * to produce Carrot-XML
 */
public class XClusterWrapper {

    private static final NumberFormat numberFormat;

    static {
        numberFormat = NumberFormat.getNumberInstance(Locale.ENGLISH);
        numberFormat.setMaximumFractionDigits(2);
        numberFormat.setMinimumFractionDigits(2);
    }

    XCluster[] clusters;
    Element root;
    
    /**
     * Construct a wrapper for a set of clusters under given element
     * @param clusters set of clusters
     * @param root DOM4j element under which cluster elements will be exported
     */
    public XClusterWrapper(XCluster[] clusters, Element root) {
        this.clusters = clusters;
        this.root = root;
    }

    public Element asElement() {
        for (int i = 0; i < clusters.length; i++) {
            root.add(convertToElement(clusters[i]));
        }
        return root;
    }

    private static Element convertToElement(XCluster cluster) {
        final DocumentFactory factory = new DocumentFactory();
        
        Element group = factory.createElement("group");
        Element title = factory.createElement("title");
        String[] labels = cluster.getLabel();
        if (labels != null) {
            for (int i = 0; i < labels.length; i++) {
                Element phrase = factory.createElement("phrase");
                phrase.setText(labels[i]);
                title.add(phrase);
            }
        } else {
            Element phrase = factory.createElement("phrase");
            phrase.setText("Group");
            title.add(phrase);
        }
        group.add(title);

        XCluster.Member[] members = cluster.getMembers();
        for (int k = 0; k < members.length; k++) {
            Element doc = factory.createElement("document");
            doc.addAttribute("refid", members[k].getSnippet().getId());
            doc.addAttribute("score", numberFormat.format(members[k].getMembership()));
            group.add(doc);
        }
        return group;
    }
}