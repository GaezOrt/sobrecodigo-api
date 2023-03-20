



1) Se armo el paginador completo para que en la seccion "proyectos" por cada proyecto que se vaya acumulando de esta forma pueda mostrar en varias paginas, desde la 1 hasta las paginas que se vayan agregando.

Lo que hice:
1)
Primero en el repositorio extendi de la clase
PagingAndSortingRepository

Este tiene a su vez el metodo "findAll" Del cual se encarga de crear la paginacion con su objeto que recibe como parametro 
Pageable pageable


2) Este metodo que es implementado en la interface del service(business) retorna todos los datos en forma ordenada y paginada
esto quiere decir que

"return pagAndSortingRepository.findAll(pageable)

y el metodo debe recibir la interface Page que es una lista que recibe objetos de tipo cliente

3)En el controlador debemos instancie el Pageable

de la sig forma:
Pageable pageRequest = PageRequest.of(page, size)
 En size  indicar el tamaño de la cantidad de paginas que solicitamos renderizar

En este caso podemos uitilizar un for o algun iterador que permita por cada vez que se creen objetos ir creando la cantidad de paginas posibles

En el controlador tambien cree un parametro que es de tipo page para pasarlo por el metodo pageRequest


paquete util.paginator

Clase PageItem y PageRender:
La clase pageRender recibe un tipo generico por que? Porque al utilizar la clase Project esta tiene sus diferentes caracteristicas 
y que va a paginar esas caracteristicas y elnumero de elementos que esta tendra.


Si en algun momento cometo un error a nivel logico pido mil disculpas y en lo posible si uds ven que se puede modificar estoy abierto a recibir las opiniones para que yo pueda mejorar ya que es mi primera vez trabajando en este nivel. 

