# DeliFit-Mobile

<h1 align="center">Hola 👋, mi nombre es Ulises Alejandro Gonzalez Romero</h1>
<h3 align="center">Un apasionado desarrollador Android de Mexico</h3>

- 🔭 Actualmente trabajo en **IDS Comercial TI** como consultor para una aplicacion Bancaria, desarrollando soluciones y mejoras de software para que los usuarios tengan una mejor experiencia al usar su app, mejorando constantemente flujos y vistas.

<br/><br/>

Principal mente podriamos listar los conceptos utilizados en esta app

<h1>Language</h1>

*Decidi utilizar kotlin ya que actualmente es el lenguaje principal de desarrollo para aplicaciones android
<br/><br/>
<b>Kotlin</b>

<br/>

<h1>User Interface</h1>
*Decidi utilizar material desing 3 para tener los componentes mas nuevos, ademas de utilizar diferentes "ViewGroups" para las diferentes vistas y retos de diseño
<br/>
*Para conectar la logica con las vista utilice "ViewBinding" ya que los "Syntetics" y "findByById" estan obsoletos y las referencias son mas certeras
<br/><br/>
<b>Desing Guides</b>
- Material desing 3, theme & components

<b>Layouts</b>
- FrameLayout
- LinearLayout
- ConstraintLayout
- CoordinatorLayout
- NestedScrollView
- RecyclerView
- CustomViews

<b>Styles</b>
- Light Theme
- Dark Theme "suppress"

<b>View linking</b>
- View Binding

<br/>

<h1>App Entry Points</h1>
*Para esta app tome la decicion de utilizar una "activity" como contenedor para poder tener los "fragments"
<br/><br/>
<b>Activitie</b>

<br/>

<h1>App Navigation</h1>
*Dentro del contenedor que es la "activity" utilice un "NavigationController" para poder facilitarme la navegacion entre mis diferentes "fragments"
<br/><br/>
</b>Navigation</b>
<br/>
</b>Fragments</b>

<br/>

<h1>Asynchronous</h1>
*Para los procesos asincronos utilice las famosas "Courrutines" combinados con los diferentes "Dispatchers" en mi caso los "IO" para las entradas y salidas y "Main" para los procesos relacionados con la vista
<br/><br/>
<b>Courrutines</b>
<br/>
<b>Suspend fuctions</b>
<br/>
<b>Dispatchers</b>

<br/>

<h1>Image Loading</h1>
*Para poder cargar las imagenes utlice unas de las dependecias externas mas famosas "Glide"
<br/><br/>
<b>Glide</b>

<br/>

<h1>Network</h1>
*Para el consumo del servicio utilice "Retrofir" para poder usar las peticiones HTTP combinado con "OkHttp" que es mi interceptor

<b>Rettofit</b>
<br/>
<b>Interceptor</b>
- OkHttp

<br/>

<h1>Architecture</h1>
*Como arquitectura decidi utilizar "MVVM" la recomendada por equipo de google, ademas que aplica muy bien para proyectos reactivos y combinado con "Clean Architecture " es la mejor opcion para tener un codigo mas limpio

<b>MVVM</b>
- (Model-View-ViewModel)
<b>Clean Architecture<b>

<br/>

<h1>Desing Partters</h1>
*Utilice el patron "Singleton" para instanciar e inectar la clase "Retrofit"
<br/>
*Tambien use el patron "Adapter" para usar adaptadores
<br/>
*Ademas utilice el patron "Observer" con el uso de "Flows" para el tema de programacion reactiva
<br/>
*Otro que use fue el patron "Dependency Injection" para no meter clases dentro de otras clases y simplificar el testing con "hilt" 
<br/>
*Utilice el patron "Repository" para aislar la capa de datos de toda la app
<br/><br/>

<b>Singleton</b>

<b>Adapter</b>

<b>Observer</b>
- Flows

<b>Dependency Injection</b>
- Hilt

<b>Repository</b>

<br/>

<h1>Gradle</h1>
*Utilice el versionado de dependencias para tener un estandar y "ProGuard" para poder optimizar, ofuscar las clases al momento de hacer el release, ademas de configtuar otras "buildConfigs"

<b>Version catalog</b>

<b>ProGuard</b>

<br/>

<h1>Service</h1>

<b>Google</b>
- Google Maps

<br/>

<h1>Code Analysis & Test</h1>

<b>Unit Test</b>
- Junit
- Mockito

<b>Android Test</b>
- Espresso

<b>Linter</b>
- Ktlint

<br/>

<h1>Tools</h1>

<b>Android Studio</b>

<b>Github</b>

<b>Mockable</b>

<b>Figma</b>
