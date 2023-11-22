package xml.escritura;

import java.math.BigInteger;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;

public class FibonacciDOM 
{

  public static void main(String[] args) {

    try {
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      //factory.setNamespaceAware(true);
      DocumentBuilder builder = factory.newDocumentBuilder();
      DOMImplementation impl = builder.getDOMImplementation();
      
      Document doc = impl.createDocument(null, "Fibonacci_Numbers", null);
       
      BigInteger low  = BigInteger.ONE;
      BigInteger high = BigInteger.ONE;

      Element root = doc.getDocumentElement();

      for (int i = 0; i < 30; i++) {
        Text space = doc.createTextNode("\n  ");
        root.appendChild(space);
        Element number = doc.createElement("fibonacci");
        Text text = doc.createTextNode(low.toString());
        number.appendChild(text);
        root.appendChild(number);
        BigInteger temp = high;
        high = high.add(low);
        low = temp;
      }
      Text lineBreak = doc.createTextNode("\n");
      root.appendChild(lineBreak);

      // Serializaci�n del documento
      TransformerFactory xformFactory = TransformerFactory.newInstance();  
      Transformer idTransform = xformFactory.newTransformer();
      Source input = new DOMSource(doc);
      Result output = new StreamResult(System.out);
      idTransform.transform(input, output);
    }
    catch (Exception ex) { 
      //captura de excepciones
    	ex.printStackTrace();
    }
  }
}