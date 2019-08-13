package org.litespring.test.v2;

import org.junit.Assert;
import org.junit.Test;
import org.litespring.beans.BeanDefinition;
import org.litespring.beans.PropertyValue;
import org.litespring.beans.factory.config.RuntimeBeanReference;
import org.litespring.beans.factory.support.DefaultBeanFactory;
import org.litespring.beans.factory.xml.XmlBeanDefinitionReader;
import org.litespring.core.io.ClassPathResource;

import java.util.List;

public class BeanDefinitionTestV2 {

    @Test
    public void testGetBeanDefinitionTest(){
        DefaultBeanFactory beanFactory=new DefaultBeanFactory();
        XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions(new ClassPathResource("petstore-v2.xml"));
        BeanDefinition bd=beanFactory.getBeanDefinition("petstore");
        List<PropertyValue> pvs=bd.getPropertyValues();
        Assert.assertTrue(pvs.size()==2);
        {
            PropertyValue pv=this.getPropertyValue("accountDao",pvs);
            Assert.assertNotNull(pv);
            Assert.assertTrue(pv.getValue() instanceof RuntimeBeanReference);
        }
        {
            PropertyValue pv=this.getPropertyValue("itemDao",pvs);
            Assert.assertNotNull(pv);
            Assert.assertTrue(pv.getValue() instanceof  RuntimeBeanReference);
        }

    }

    private PropertyValue getPropertyValue(String name, List<PropertyValue> pvs) {
        for(PropertyValue pv:pvs){
            if(name.equals(pv.getName())){
                return pv;
            }
        }
        return null;
    }
}
