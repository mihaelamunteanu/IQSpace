PGDMP     (                    w           IQSpaceTest    11.1    11.1 +    3           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            4           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            5           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false            6           1262    32768    IQSpaceTest    DATABASE     �   CREATE DATABASE "IQSpaceTest" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'English_United States.1252' LC_CTYPE = 'English_United States.1252';
    DROP DATABASE "IQSpaceTest";
             postgres    false            �            1259    32810 	   questions    TABLE     5  CREATE TABLE public.questions (
    id bigint NOT NULL,
    test_id bigint NOT NULL,
    question_type character varying NOT NULL,
    question character varying(1000) NOT NULL,
    hint1 character varying(300),
    hint2 character varying(300),
    other_observations character varying(500),
    question_number bigint NOT NULL,
    answer character varying NOT NULL,
    answer_explanations character varying(1000),
    wrong_answer1 character varying,
    wrong_answer2 character varying,
    image1 character varying DEFAULT 'Default.png'::character varying
);
    DROP TABLE public.questions;
       public         postgres    false            �            1259    32808    questions_id_seq    SEQUENCE     y   CREATE SEQUENCE public.questions_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.questions_id_seq;
       public       postgres    false    203            7           0    0    questions_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.questions_id_seq OWNED BY public.questions.id;
            public       postgres    false    202            �            1259    32781    tests    TABLE     -  CREATE TABLE public.tests (
    id bigint NOT NULL,
    test_name character varying NOT NULL,
    observations character varying,
    creation_date date NOT NULL,
    test_type character varying NOT NULL,
    number_of_questions bigint DEFAULT 20,
    modification_date date DEFAULT now() NOT NULL
);
    DROP TABLE public.tests;
       public         postgres    false            �            1259    32779    test_results_id_seq    SEQUENCE     |   CREATE SEQUENCE public.test_results_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.test_results_id_seq;
       public       postgres    false    199            8           0    0    test_results_id_seq    SEQUENCE OWNED BY     D   ALTER SEQUENCE public.test_results_id_seq OWNED BY public.tests.id;
            public       postgres    false    198            �            1259    32792    visitor_test_result    TABLE       CREATE TABLE public.visitor_test_result (
    id bigint NOT NULL,
    test_date date NOT NULL,
    test_result bigint NOT NULL,
    test_observation character varying(300),
    used_mail character varying(100),
    visitor_id bigint NOT NULL,
    test_id bigint NOT NULL
);
 '   DROP TABLE public.visitor_test_result;
       public         postgres    false            �            1259    32790    visitor_test_result_id_seq    SEQUENCE     �   CREATE SEQUENCE public.visitor_test_result_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 1   DROP SEQUENCE public.visitor_test_result_id_seq;
       public       postgres    false    201            9           0    0    visitor_test_result_id_seq    SEQUENCE OWNED BY     Y   ALTER SEQUENCE public.visitor_test_result_id_seq OWNED BY public.visitor_test_result.id;
            public       postgres    false    200            �            1259    32773    visitors    TABLE       CREATE TABLE public.visitors (
    id bigint NOT NULL,
    mail character varying(60),
    subscription_date date NOT NULL,
    first_name character varying(60),
    last_name character varying(60),
    other_info character varying(200),
    telephone_number character varying(20)
);
    DROP TABLE public.visitors;
       public         postgres    false            �            1259    32771    vizitors_id_seq    SEQUENCE     x   CREATE SEQUENCE public.vizitors_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.vizitors_id_seq;
       public       postgres    false    197            :           0    0    vizitors_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.vizitors_id_seq OWNED BY public.visitors.id;
            public       postgres    false    196            �            1259    32827    wrong_answers    TABLE     �   CREATE TABLE public.wrong_answers (
    id bigint NOT NULL,
    question_id bigint NOT NULL,
    wrong_answer character varying(500) NOT NULL,
    other_observations character varying(300)
);
 !   DROP TABLE public.wrong_answers;
       public         postgres    false            �            1259    32825    wrong_answers_id_seq    SEQUENCE     }   CREATE SEQUENCE public.wrong_answers_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.wrong_answers_id_seq;
       public       postgres    false    205            ;           0    0    wrong_answers_id_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.wrong_answers_id_seq OWNED BY public.wrong_answers.id;
            public       postgres    false    204            �
           2604    32813    questions id    DEFAULT     l   ALTER TABLE ONLY public.questions ALTER COLUMN id SET DEFAULT nextval('public.questions_id_seq'::regclass);
 ;   ALTER TABLE public.questions ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    203    202    203            �
           2604    32784    tests id    DEFAULT     k   ALTER TABLE ONLY public.tests ALTER COLUMN id SET DEFAULT nextval('public.test_results_id_seq'::regclass);
 7   ALTER TABLE public.tests ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    198    199    199            �
           2604    32795    visitor_test_result id    DEFAULT     �   ALTER TABLE ONLY public.visitor_test_result ALTER COLUMN id SET DEFAULT nextval('public.visitor_test_result_id_seq'::regclass);
 E   ALTER TABLE public.visitor_test_result ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    200    201    201            �
           2604    32776    visitors id    DEFAULT     j   ALTER TABLE ONLY public.visitors ALTER COLUMN id SET DEFAULT nextval('public.vizitors_id_seq'::regclass);
 :   ALTER TABLE public.visitors ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    196    197    197            �
           2604    32830    wrong_answers id    DEFAULT     t   ALTER TABLE ONLY public.wrong_answers ALTER COLUMN id SET DEFAULT nextval('public.wrong_answers_id_seq'::regclass);
 ?   ALTER TABLE public.wrong_answers ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    204    205    205            .          0    32810 	   questions 
   TABLE DATA               �   COPY public.questions (id, test_id, question_type, question, hint1, hint2, other_observations, question_number, answer, answer_explanations, wrong_answer1, wrong_answer2, image1) FROM stdin;
    public       postgres    false    203   �3       *          0    32781    tests 
   TABLE DATA               ~   COPY public.tests (id, test_name, observations, creation_date, test_type, number_of_questions, modification_date) FROM stdin;
    public       postgres    false    199   �D       ,          0    32792    visitor_test_result 
   TABLE DATA               {   COPY public.visitor_test_result (id, test_date, test_result, test_observation, used_mail, visitor_id, test_id) FROM stdin;
    public       postgres    false    201   KE       (          0    32773    visitors 
   TABLE DATA               t   COPY public.visitors (id, mail, subscription_date, first_name, last_name, other_info, telephone_number) FROM stdin;
    public       postgres    false    197   hE       0          0    32827    wrong_answers 
   TABLE DATA               Z   COPY public.wrong_answers (id, question_id, wrong_answer, other_observations) FROM stdin;
    public       postgres    false    205   �E       <           0    0    questions_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.questions_id_seq', 24, true);
            public       postgres    false    202            =           0    0    test_results_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.test_results_id_seq', 3, true);
            public       postgres    false    198            >           0    0    visitor_test_result_id_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('public.visitor_test_result_id_seq', 1, false);
            public       postgres    false    200            ?           0    0    vizitors_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.vizitors_id_seq', 1, false);
            public       postgres    false    196            @           0    0    wrong_answers_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.wrong_answers_id_seq', 1, false);
            public       postgres    false    204            �
           2606    32818    questions questions_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.questions
    ADD CONSTRAINT questions_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.questions DROP CONSTRAINT questions_pkey;
       public         postgres    false    203            �
           2606    32789    tests test_results_pkey 
   CONSTRAINT     U   ALTER TABLE ONLY public.tests
    ADD CONSTRAINT test_results_pkey PRIMARY KEY (id);
 A   ALTER TABLE ONLY public.tests DROP CONSTRAINT test_results_pkey;
       public         postgres    false    199            �
           2606    32797 ,   visitor_test_result visitor_test_result_pkey 
   CONSTRAINT     j   ALTER TABLE ONLY public.visitor_test_result
    ADD CONSTRAINT visitor_test_result_pkey PRIMARY KEY (id);
 V   ALTER TABLE ONLY public.visitor_test_result DROP CONSTRAINT visitor_test_result_pkey;
       public         postgres    false    201            �
           2606    32778    visitors vizitors_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.visitors
    ADD CONSTRAINT vizitors_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.visitors DROP CONSTRAINT vizitors_pkey;
       public         postgres    false    197            �
           2606    32835     wrong_answers wrong_answers_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.wrong_answers
    ADD CONSTRAINT wrong_answers_pkey PRIMARY KEY (id);
 J   ALTER TABLE ONLY public.wrong_answers DROP CONSTRAINT wrong_answers_pkey;
       public         postgres    false    205            �
           2606    32819    questions test_question_fk    FK CONSTRAINT     y   ALTER TABLE ONLY public.questions
    ADD CONSTRAINT test_question_fk FOREIGN KEY (test_id) REFERENCES public.tests(id);
 D   ALTER TABLE ONLY public.questions DROP CONSTRAINT test_question_fk;
       public       postgres    false    203    2723    199            �
           2606    32803 #   visitor_test_result test_results_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.visitor_test_result
    ADD CONSTRAINT test_results_fk FOREIGN KEY (test_id) REFERENCES public.tests(id);
 M   ALTER TABLE ONLY public.visitor_test_result DROP CONSTRAINT test_results_fk;
       public       postgres    false    201    2723    199            �
           2606    32798 *   visitor_test_result visitor_test_result_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.visitor_test_result
    ADD CONSTRAINT visitor_test_result_fk FOREIGN KEY (visitor_id) REFERENCES public.visitors(id);
 T   ALTER TABLE ONLY public.visitor_test_result DROP CONSTRAINT visitor_test_result_fk;
       public       postgres    false    201    2721    197            �
           2606    32836 *   wrong_answers wrong_aswers_for_question_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.wrong_answers
    ADD CONSTRAINT wrong_aswers_for_question_fk FOREIGN KEY (question_id) REFERENCES public.questions(id);
 T   ALTER TABLE ONLY public.wrong_answers DROP CONSTRAINT wrong_aswers_for_question_fk;
       public       postgres    false    2727    205    203            .      x��Z�n�>����KH{5�.)QR,4)�,�m��3�˦f�'=3k����C� ��3Ht�C�I�}�=�KJv�!��ݙ���������4�m��5�a�
�\_�Z�
�:�z�Z�j?;�2mg�B}�J����`k�=�9�L���v�'�K�~Sm�:��s���m�� *�UZMq?�ĺ�[�q] WZ�`7y�{��}ܦ[��Ȉ�c
	kݝe�<Txo�!�j��iStv�t���o�^��X��zi!ωl�F�[��#�>�ʇ\po���WUo�9�9-����i���nͳ��{�{{�C�{_ճw��� ���������P�ݴB����~�6���E�T�ǕZ�F�)��j��ª]0���=U��!?I@�KK�}=�g��@��!v v<��Eϻ�I�jV*x����-�]�Mw��4֕&�J��^H�F��H+{��(�(w�(��1����R�A�c:�n|��(F_ru�\M��bW�����lz'���1\���hw�b�1p r��,W_��tvp%�#8�w ��z�W:d��;K���uP	N=���V�FNUf�^�T^i��� �Kć���$t��v�%���7�����ϖ��j�7�E})���� ��bѨ�Gfa���	L��U��<��ھ��)�f��vz{r��h�d�»
:ɡ��j�Q�C���>�~t3͐��轛(g�`�������1l��K-'u���;t%�CzQsj�F�����գ�R�����+�8jQi��Ƈ����:��NT���yz�����	����FʑisQT}��b3^0Y�ě<;:>=|v���ɫ�?{4Y��e��m��<Ik��MÈ����(���j��#�[3�?	=�w�����K�u|y�7�G��?�Nl�%4i����}�+8���A��c�A"�9c8x���(.eU�i-�IDU�C#3��Zs}I����nK���b	&j�����h#�T@9��{�_dE�5<�J�����mx��r�>ي4�ΜKtݘ�E>0������B]�E*�A҇��K~�������+a����ά|��;UJ-J9�d�4-���?��D� l�~e���\�|E����ҹ:v���Z5�A�bNhuRΰ��ν��Tf�Mo	[Ȓg��Y���_aK1�w�Mr4����E��+ȸ6�p�}˨������;��C��Ö+���_��3�fò�G�ߤ�����P�'��z�$�b�RYK� 5ĜZ7H �A���/u�_��&R˳/�R�^ y��(fxl[���"�`�������j��\�g�����a/�`�DDfR�+[���h.�e��P�ؐ�E�Z���u$�

��~`�&,x�?e�YvPj�W�0����w���q����v��!l]�V}����-�@��:��%L^��\�X�%˪j��>Z�Yڈ<|d�J}�[��2�~�R̹M�)�>b�07x��'�p��}�~�UwX�N��kSϙ�y� b��E��p�%H��A�G�s�$q-U@d��A���p̯�W����Fv�~��`�{2��1ٙ�? �3�xG�ϯ(	����89`�k�H�zeVP��BL���_�6A�$ c����8c8g{�) �-CElS�k>��9�Wt���4�v#��G��W�ј��܇�>��E�Q��̋Q����S���h�ݹa�8�h����u%_1 ����,й0S�^B�N�pNU�3���`:m!���Z_~�vM�
�ɚ������5H>��ӛ����1����Gh_#��lP���F�.#���H�ǡ����c>�5J+�]J� ��B���y���hZ��-�А��!X���2�X��V�n���B�i���<�@�������\�ŭ�>Z�0��F(��M"�'��G��fA�k�[��m��+$�^�:���^-��pB"�����As �P����!��x#yp�}N��-��|�Α�5aꡒ���C}��������_����&��7_�ޟ]��׳���Vͷ�������(O�nH���ic򑬎:��������niMl�R��ZF�^=S��T�;˄P8�ct�#�X��.Y �e���EP��d�)�07Tn6:@YF"�n������w�_��Pe*��w�����}bt�	���ε��hd9�ZUѧ��o�	a���i���q��	�y�ք)��Y����qHNP��j�����	J����^�#;�g]]}����珞>1����"ݸ���F�,�S«�ٸl}�����_���<C��*��Ҟ`|��~�=Y��y���<|' �vx��`h_�hG�?�K)|?���7n2�Z&�b�4N�?�%ZI�9��\Z;�TT`�&e�����y*/�ص���,�Κ1�� �8�[�����P�1�[P��jy<S^4���B��	��8tE����e�pm��p�O��4�J�n�Xt��vL�\0�p�^����c!x�t�&�?`��\^|�$T�@�������0�t�1�c�l�|�g�=`M�`e��ɑ){4��sv����6vbL�8|a�@�$���g�IC�[��������H�)(>f�~^Y�����Z���C靖�6Qgh`������=Z�ஙie�2뻓	˂b&Ҝ�H�6�/X\ld-hJ�_��T������|��x����v��o�ٻ�>��ƹɲV���;�Wpe�'q���=��F�I��t��Tx�6	aX�r�2����0*N�⤖B΢YZB��Ο*�>b��<SF�0��܉/s�>'���Kk#d�ϟ��Ǩyk�k�tr�&�N$�^#��I�(�wЛu(R������#����֍�@}4��p�W�����6�\���N�n��lΆ�^�Df@kmNT;�)�u�(j�;��'��ҹBIzԵ�(Ds�$�A�F���+:EK
�dW5��F��U#��G~��oF폿��-��E�h��j���@RD�>�o+F,q>�4^h�#(��R���}��� ��n���	��Ͽ���u�/���h�����ˬ7T ]�t@'O9����&N�:;���ɭ����k�Q.@߶���Yg?D��)����Sk�i��ւ���x�?�45B�Hx�<A�4�+@FoP�z��؇�}�T/�" pv��=ѭ���/8f���Lj<�U�7�d[I�&��3��
���^���1ֳ�TF�"��$pg"^B��t/�b)KN��m�+�aq�&ѫ���(��e��AI�[��6�����[��a8GD��8��E��V+�����%� eMmk�vr�A`��L�q�5&2�6����N*�{=��M�Z�<��!��V�.�J�!��"kO���L��o�U�N���?�@$nD�I���s�)L�#N�[�W�׭}��#/c� ��+�v�[����nt����4��$!]1U�@��1E�]<b9��~.��J��.�	�+_�I���rA�C�5EJ�E�a�Bkk!iRk�'}��yv �sp���>�K�n�/�����_�<��ϊ3��0�
�>�����/�]8 $.�_�F2u+���(Q���gA�*7�8�W�NwGl��4�a�A����'_���o��J0�&M9�Yz������^�\�~ɛ�!�0��2��+��^��N��/�ݒ��+�x������y��ۿ���"��E����)]���D�i׹���uP��a�B��UT+�_#��{@�Ѐԑ��V.łnl��������t�!�6��NF���m�d� /��M��-�͡pF�❄�\�$q����Ǧ̷�i�Kۋ������qH���3.�\B�.'���\H�C'Au�B���ʹ�[����x�b�8�ZG�+��2�M���b����Qqr1jk��}��r��V��Z5�+i���cˎ��vtD��3o4/�6fC%��<ˮ�iO�������	V��W/�=	��:뺦}p��W=z��[��v�(���o���?˘��l&���e��U7�+���1i{�v&���ޗ�3��   �
��ڷ�?s8��q�n���-N@Vf�-xY�Ž����������'*�]�~2�"��6>_S��qs%���]0��|i(����'��Z��v$��V���&�(6�y��1��=��AW�3�~%#���'ŘU��9��:�Ͼ�?O���u�N ����N���u��gx�X��w��;]�o��Ej�0T�x�o{�.޵��/���2��ܚF��fB:���N�d�VݙQǁ-5�$>�3��(<��AU�"�D�8�s��y���p�y���7n��7]�j      *   �   x���1
�0Eg��@�-'C��t��E8��1�s��@o�>��x���U�c��u�n� ���,ȇ���)xxK�b�G)��*IT�VW��	(�Ks�6�2�@��M`]tT��*Խ��4��u�	��8�>�;C�      ,      x������ � �      (      x������ � �      0      x������ � �     