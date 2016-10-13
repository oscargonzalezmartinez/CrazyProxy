# CrazyProxy

La mayoría de nuestros proyectos dependen de otros sistemas, cuando todo va bien, es maravilloso, pero, cuando ese sistema ajeno al nuestro empieza a fallar, ¿Cómo nos comportamos?¿sosmo capaces de degradar el sistema de forma limpia?¿se verán afectadas el resto de funcionalidades que no depende de sistemas ajenos.

CrazyProxy ha nacido para permitirnos validad estas hipótesis con un esfuerzo mínimo. Simplemente se interpone entre tu sistema y el sistema externo y empieza a degradarse, ¿quieres fallos? te los doy, ¿quieres tiempo de respuesta malísimos? te los doy.
De este modo puedes validar tu sistema contra un entorno hostil.

El poryecto es muy sencillo. Un Jetty autocontenido que redirige las peticiones al sistema que tu le digas y se comporta como tu indicas.

Configuración:

Para configurar el servicio destino

-Dtarget=url servidor destino

Nivel de errores

-Derror.threshold=50

Fallarán el 50% de las llamadas

-Ddelay=1000
A cada petición le añade este tiempo de retardo.

También lo puedes configurar con un fichero properties
-Dconfig.file=MisPropiedades.porperties 