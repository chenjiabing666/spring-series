package com.javacode2018.spel;

import com.javacode2018.spel.test1.LessonModel;
import com.javacode2018.spel.test1.MainConfig;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.expression.BeanFactoryResolver;
import org.springframework.expression.*;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.lang.reflect.Method;
import java.util.*;

public class SpelTest {
    @Test
    public void test1() {
        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("('Hello' + ' World').concat(#end)");
        EvaluationContext context = new StandardEvaluationContext();
        context.setVariable("end", "!");
        System.out.println(expression.getValue(context));
    }

    @Test
    public void testParserContext() {
        ExpressionParser parser = new SpelExpressionParser();
        ParserContext parserContext = new ParserContext() {
            @Override
            public boolean isTemplate() {
                return true;
            }

            @Override
            public String getExpressionPrefix() {
                return "#{";
            }

            @Override
            public String getExpressionSuffix() {
                return "}";
            }
        };
        String template = "#{'Hello '}#{'World!'}";
        Expression expression = parser.parseExpression(template, parserContext);
        System.out.println(expression.getValue());
    }

    @Test
    public void test2() {
        ExpressionParser parser = new SpelExpressionParser();

        String str1 = parser.parseExpression("'Hello World!'").getValue(String.class);
        int int1 = parser.parseExpression("1").getValue(Integer.class);
        long long1 = parser.parseExpression("-1L").getValue(long.class);
        float float1 = parser.parseExpression("1.1").getValue(Float.class);
        double double1 = parser.parseExpression("1.1E+2").getValue(double.class);
        int hex1 = parser.parseExpression("0xa").getValue(Integer.class);
        long hex2 = parser.parseExpression("0xaL").getValue(long.class);
        boolean true1 = parser.parseExpression("true").getValue(boolean.class);
        boolean false1 = parser.parseExpression("false").getValue(boolean.class);
        Object null1 = parser.parseExpression("null").getValue(Object.class);

        System.out.println("str1=" + str1);
        System.out.println("int1=" + int1);
        System.out.println("long1=" + long1);
        System.out.println("float1=" + float1);
        System.out.println("double1=" + double1);
        System.out.println("hex1=" + hex1);
        System.out.println("hex2=" + hex2);
        System.out.println("true1=" + true1);
        System.out.println("false1=" + false1);
        System.out.println("null1=" + null1);
    }

    @Test
    public void test3() {
        ExpressionParser parser = new SpelExpressionParser();
        boolean v1 = parser.parseExpression("1>2").getValue(boolean.class);
        boolean between1 = parser.parseExpression("1 between {1,2}").getValue(boolean.class);
        System.out.println("v1=" + v1);
        System.out.println("between1=" + between1);
    }

    @Test
    public void test4() {
        ExpressionParser parser = new SpelExpressionParser();

        boolean result1 = parser.parseExpression("2>1 and (!true or !false)").getValue(boolean.class);
        boolean result2 = parser.parseExpression("2>1 && (!true || !false)").getValue(boolean.class);

        boolean result3 = parser.parseExpression("2>1 and (NOT true or NOT false)").getValue(boolean.class);
        boolean result4 = parser.parseExpression("2>1 && (NOT true || NOT false)").getValue(boolean.class);

        System.out.println("result1=" + result1);
        System.out.println("result2=" + result2);
        System.out.println("result3=" + result3);
        System.out.println("result4=" + result4);
    }

    @Test
    public void testClassTypeExpression() {
        ExpressionParser parser = new SpelExpressionParser();
        //java.lang????????????
        Class<String> result1 = parser.parseExpression("T(String)").getValue(Class.class);
        System.out.println(result1);

        //??????????????????
        String expression2 = "T(com.javacode2018.spel.SpelTest)";
        Class<SpelTest> value = parser.parseExpression(expression2).getValue(Class.class);
        System.out.println(value == SpelTest.class);

        //?????????????????????
        int result3 = parser.parseExpression("T(Integer).MAX_VALUE").getValue(int.class);
        System.out.println(result3 == Integer.MAX_VALUE);

        //?????????????????????
        int result4 = parser.parseExpression("T(Integer).parseInt('1')").getValue(int.class);
        System.out.println(result4);
    }

    @Test
    public void testConstructorExpression() {
        ExpressionParser parser = new SpelExpressionParser();
        String result1 = parser.parseExpression("new String('??????java')").getValue(String.class);
        System.out.println(result1);

        Date result2 = parser.parseExpression("new java.util.Date()").getValue(Date.class);
        System.out.println(result2);
    }

    @Test
    public void testInstanceOfExpression() {
        ExpressionParser parser = new SpelExpressionParser();
        Boolean value = parser.parseExpression("'??????' instanceof T(String)").getValue(Boolean.class);
        System.out.println(value);
    }

    @Test
    public void testVariableExpression() {
        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext context = new StandardEvaluationContext();
        context.setVariable("name", "??????java");
        context.setVariable("lesson", "Spring??????");

        //??????name?????????lesson??????
        String name = parser.parseExpression("#name").getValue(context, String.class);
        System.out.println(name);
        String lesson = parser.parseExpression("#lesson").getValue(context, String.class);
        System.out.println(lesson);

        //StandardEvaluationContext???????????????root?????????????????????#root?????????root??????
        context = new StandardEvaluationContext("??????root??????");
        String rootObj = parser.parseExpression("#root").getValue(context, String.class);
        System.out.println(rootObj);

        //#this???????????????????????????????????????
        String thisObj = parser.parseExpression("#this").getValue(context, String.class);
        System.out.println(thisObj);
    }

    @Test
    public void testFunctionExpression() throws SecurityException, NoSuchMethodException {
        //??????2?????????,registerFunction???setVariable??????????????????????????????????????????registerFunction?????????
        StandardEvaluationContext context = new StandardEvaluationContext();
        Method parseInt = Integer.class.getDeclaredMethod("parseInt", String.class);
        context.registerFunction("parseInt1", parseInt);
        context.setVariable("parseInt2", parseInt);

        ExpressionParser parser = new SpelExpressionParser();
        System.out.println(parser.parseExpression("#parseInt1('3')").getValue(context, int.class));
        System.out.println(parser.parseExpression("#parseInt2('3')").getValue(context, int.class));

        String expression1 = "#parseInt1('3') == #parseInt2('3')";
        boolean result1 = parser.parseExpression(expression1).getValue(context, boolean.class);
        System.out.println(result1);
    }

    @Test
    public void testAssignExpression() {
        ExpressionParser parser = new SpelExpressionParser();
        //1.???root????????????
        EvaluationContext context = new StandardEvaluationContext("v1");
        context.setVariable("v1", "v1");
        parser.parseExpression("#v1").setValue(context, "v2");
        System.out.println(parser.parseExpression("#v1").getValue(context, String.class));
    }

    @Test
    public void testAssignExpression1() {
        Object user = new Object() {
            private String name;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            @Override
            public String toString() {
                return "$classname{" +
                        "name='" + name + '\'' +
                        '}';
            }
        };
        {
            //user???root??????
            ExpressionParser parser = new SpelExpressionParser();
            EvaluationContext context = new StandardEvaluationContext(user);
            parser.parseExpression("#root.name").setValue(context, "??????java");
            System.out.println(parser.parseExpression("#root").getValue(context, user.getClass()));
        }
        {
            //user?????????
            ExpressionParser parser = new SpelExpressionParser();
            EvaluationContext context = new StandardEvaluationContext();
            context.setVariable("user", user);
            parser.parseExpression("#user.name").setValue(context, "??????java");
            System.out.println(parser.parseExpression("#user").getValue(context, user.getClass()));
        }
    }

    public static class Car {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Car{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public static class User {
        private Car car;

        public Car getCar() {
            return car;
        }

        public void setCar(Car car) {
            this.car = car;
        }

        @Override
        public String toString() {
            return "User{" +
                    "car=" + car +
                    '}';
        }
    }

    @Test
    public void test5() {
        User user = new User();
        EvaluationContext context = new StandardEvaluationContext();
        context.setVariable("user", user);

        ExpressionParser parser = new SpelExpressionParser();
        //??????.???????????????user.car.name?????????????????????user.car??????
        try {
            System.out.println(parser.parseExpression("#user.car.name").getValue(context, String.class));
        } catch (EvaluationException | ParseException e) {
            System.out.println("????????????" + e.getMessage());
        }
        //?????????????????????????.???????????????null??????
        System.out.println(parser.parseExpression("#user?.car?.name").getValue(context, String.class));

        Car car = new Car();
        car.setName("?????????");
        user.setCar(car);

        System.out.println(parser.parseExpression("#user?.car?.toString()").getValue(context, String.class));
    }

    @Test
    public void test6() {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        User user = new User();
        Car car = new Car();
        car.setName("?????????");
        user.setCar(car);
        factory.registerSingleton("user", user);

        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setBeanResolver(new BeanFactoryResolver(factory));

        ExpressionParser parser = new SpelExpressionParser();
        User userBean = parser.parseExpression("@user").getValue(context, User.class);
        System.out.println(userBean);
        System.out.println(userBean == factory.getBean("user"));
    }

    @Test
    public void test7() {
        ExpressionParser parser = new SpelExpressionParser();
        //???????????????????????????List
        List<Integer> result2 = parser.parseExpression("{}").getValue(List.class);
        //????????????????????????????????????????????????List
        List<Integer> result1 = parser.parseExpression("{1,2,3}").getValue(List.class);
        Assert.assertEquals(new Integer(1), result1.get(0));
        try {
            result1.set(0, 2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //???????????????????????????????????????????????????????????????????????????List???
        //??????????????????????????????
        String expression3 = "{{1+2,2+4},{3,4+4}}";
        List<List<Integer>> result3 = parser.parseExpression(expression3).getValue(List.class);
        result3.get(0).set(0, 1);
        System.out.println(result3);
        //??????????????????????????????
        int[] result4 = parser.parseExpression("new int[2]{1,2}").getValue(int[].class);
        System.out.println(result4[1]);
        //??????????????????????????????
        int[] result5 = parser.parseExpression("new int[1]").getValue(int[].class);
        System.out.println(result5[0]);
    }

    @Test
    public void test8() {
        ExpressionParser parser = new SpelExpressionParser();

        //??????list?????????
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);

        EvaluationContext context1 = new StandardEvaluationContext();
        context1.setVariable("collection", list);
        parser.parseExpression("#collection[1]").setValue(context1, 4);
        int result1 = parser.parseExpression("#collection[1]").getValue(context1, int.class);
        System.out.println(result1);

        //??????map?????????
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("a", 1);
        EvaluationContext context2 = new StandardEvaluationContext();
        context2.setVariable("map", map);
        parser.parseExpression("#map['a']").setValue(context2, 4);
        Integer result2 = parser.parseExpression("#map['a']").getValue(context2, int.class);
        System.out.println(result2);
    }

    @Test
    public void test9() {
        ExpressionParser parser = new SpelExpressionParser();

        //1.?????????????????????
        List<Integer> list = new ArrayList<Integer>();
        list.add(4);
        list.add(5);
        EvaluationContext context1 = new StandardEvaluationContext();
        context1.setVariable("list", list);
        Collection<Integer> result1 = parser.parseExpression("#list.![#this+1]").getValue(context1, Collection.class);
        result1.forEach(System.out::println);

        System.out.println("------------");
        //2.????????????
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("a", 1);
        map.put("b", 2);
        EvaluationContext context2 = new StandardEvaluationContext();
        context2.setVariable("map", map);
        List<Integer> result2 = parser.parseExpression("#map.![value+1]").getValue(context2, List.class);
        result2.forEach(System.out::println);
    }

    @Test
    public void test10() {
        ExpressionParser parser = new SpelExpressionParser();

        //1.?????????????????????
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(4);
        list.add(5);
        list.add(7);
        EvaluationContext context1 = new StandardEvaluationContext();
        context1.setVariable("list", list);
        Collection<Integer> result1 = parser.parseExpression("#list.?[#this>4]").getValue(context1, Collection.class);
        result1.forEach(System.out::println);

        System.out.println("------------");
        //2.????????????
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        EvaluationContext context2 = new StandardEvaluationContext();
        context2.setVariable("map", map);
        Map<String, Integer> result2 = parser.parseExpression("#map.?[key!='a']").getValue(context2, Map.class);
        result2.forEach((key, value) -> {
            System.out.println(key + ":" + value);
        });
        System.out.println("------------");
        List<Integer> result3 = parser.parseExpression("#map.?[key!='a'].![value+1]").getValue(context2, List.class);
        result3.forEach(System.out::println);
    }

    @Test
    public void test11() {
        //???????????????
        SpelExpressionParser parser = new SpelExpressionParser();
        //????????????????????????
        ParserContext context = new TemplateParserContext("%{", "}");
        Expression expression = parser.parseExpression("??????:%{#name},??????????????????:%{#lesson}", context);

        //??????????????????????????????
        EvaluationContext evaluationContext = new StandardEvaluationContext();
        evaluationContext.setVariable("name", "??????java");
        evaluationContext.setVariable("lesson", "spring????????????!");
        //?????????
        String value = expression.getValue(evaluationContext, String.class);
        System.out.println(value);
    }

@Test
public void test12() {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
    context.register(MainConfig.class);
    context.refresh();
    LessonModel lessonModel = context.getBean(LessonModel.class);
    System.out.println(lessonModel);
}

}
