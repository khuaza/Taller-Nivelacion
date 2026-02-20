# Git - Preguntas Teóricas

## 1. ¿Qué es un repositorio en Git y cómo se diferencia de un proyecto "normal"?

Un **repositorio en Git** es un directorio que, además de contener los archivos del proyecto, incluye una carpeta oculta `.git` donde Git almacena todo el historial de cambios, ramas, configuraciones y metadatos. A diferencia de un proyecto "normal" (sin control de versiones), un repositorio Git permite rastrear cada modificación, volver a versiones anteriores, colaborar con otros desarrolladores y trabajar en múltiples líneas de desarrollo de forma simultánea.

---

## 2. ¿Cuáles son las tres áreas principales de Git?

Git organiza el trabajo en tres áreas:

| Área | Descripción |
|------|-------------|
| **Working Directory** | Es donde se encuentran y editan los archivos del proyecto en disco. |
| **Staging Area (Index)** | Zona intermedia donde se preparan los cambios que se incluirán en el próximo commit. |
| **Repository (.git)** | Base de datos local donde se almacenan los commits y el historial completo del proyecto. |

---

## 3. ¿Cómo representa Git los cambios internamente?

Git utiliza cuatro tipos de objetos internos:

- **Blob**: Almacena el contenido de un archivo (sin nombre ni ruta).
- **Tree**: Representa un directorio; apunta a blobs y otros trees con sus nombres.
- **Commit**: Apunta a un tree (estado del proyecto), tiene metadatos (autor, fecha, mensaje) y referencia al commit padre.
- **Tag**: Apunta a un commit específico con un nombre legible (por ejemplo, `v1.0`).

Cada objeto se identifica por un hash SHA-1 único generado a partir de su contenido.

---

## 4. ¿Cómo se crea un commit y qué información almacena?

Un commit se crea con:

```bash
git add .
git commit -m "Mensaje descriptivo"
```

Un objeto commit almacena:
- Referencia al **tree** que representa el estado del proyecto.
- **Hash del commit padre** (o padres en caso de merge).
- **Autor**: nombre, correo y fecha.
- **Committer**: quien realizó el commit.
- **Mensaje** del commit.

---

## 5. ¿Cuál es la diferencia entre `git pull` y `git fetch`?

- **`git fetch`**: Descarga los cambios del repositorio remoto al repositorio local, pero **no** los fusiona con la rama actual. Los cambios quedan en ramas remotas (`origin/main`).
- **`git pull`**: Hace un `fetch` y automáticamente realiza un `merge` (o `rebase`) de los cambios descargados en la rama actual.

> En resumen: `git pull = git fetch + git merge`

---

## 6. ¿Qué es un branch (rama) en Git?

Un **branch** es simplemente un puntero ligero que apunta a un commit específico. Permite trabajar en nuevas funcionalidades o correcciones de forma aislada sin afectar la rama principal. Git gestiona las ramas mediante punteros que avanzan automáticamente con cada nuevo commit.

```bash
git branch nueva-rama    # crear rama
git checkout nueva-rama  # cambiar a rama
git checkout -b nueva-rama  # crear y cambiar en un paso
```

---

## 7. ¿Cómo se realiza un merge y qué conflictos pueden surgir?

Un merge combina el historial de dos ramas:

```bash
git checkout main
git merge feature-rama
```

**Tipos de conflictos**: Ocurren cuando dos ramas modificaron la misma línea del mismo archivo de forma diferente. Git marca el conflicto en el archivo:

```
<<<<<<< HEAD
código de la rama actual
=======
código de la otra rama
>>>>>>> feature-rama
```

**Resolución**: Editar manualmente el archivo, elegir qué cambios conservar, luego:

```bash
git add archivo-conflicto.java
git commit -m "Resolver conflicto de merge"
```

---

## 8. ¿Cómo funciona el área de staging (`git add`)?

El área de staging es una "zona de preparación" donde se agregan selectivamente los cambios que formarán parte del próximo commit. Si se omite `git add`, los cambios permanecen solo en el working directory y **no se incluirán en el commit**.

```bash
git add archivo.java       # añadir archivo específico
git add .                  # añadir todos los cambios
git status                 # ver estado de las áreas
```

---

## 9. ¿Qué es el archivo `.gitignore`?

El archivo `.gitignore` contiene patrones de archivos y directorios que Git debe **ignorar** (no rastrear). Es útil para excluir archivos de configuración local, credenciales, compilados o dependencias.

```
# Ejemplo de .gitignore para Java
*.class
*.jar
/bin/
/.idea/
node_modules/
```

Git no hará seguimiento de ningún archivo que coincida con esos patrones.

---

## 10. ¿Cuál es la diferencia entre `--amend` y un nuevo commit?

- **`git commit --amend`**: Modifica el **último commit** ya existente (cambia su mensaje o agrega archivos olvidados). Reescribe el historial, por lo que no se recomienda usar en ramas compartidas.
- **Nuevo commit**: Crea un commit adicional en el historial, preservando el anterior intacto.

```bash
git commit --amend -m "Nuevo mensaje corregido"
```

---

## 11. ¿Cómo se utiliza `git stash`?

`git stash` guarda temporalmente los cambios no confirmados del working directory para que puedas cambiar de rama o contexto sin perderlos ni hacer un commit prematuro.

```bash
git stash           # guardar cambios
git stash list      # listar stashes guardados
git stash pop       # recuperar el último stash y eliminarlo
git stash apply     # recuperar sin eliminar del stash
```

**Escenarios útiles**: Cuando necesitas cambiar urgentemente de rama pero tienes trabajo a medias.

---

## 12. ¿Cómo deshacer cambios en Git?

| Comando | ¿Qué hace? |
|---------|-----------|
| `git checkout -- archivo` | Descarta cambios en working directory |
| `git reset HEAD archivo` | Saca un archivo del staging sin borrar cambios |
| `git reset --soft HEAD~1` | Deshace el último commit, conservando los cambios en staging |
| `git reset --hard HEAD~1` | Deshace el último commit y **borra** los cambios |
| `git revert <hash>` | Crea un nuevo commit que deshace los cambios de un commit anterior (seguro en ramas compartidas) |

---

## 13. ¿Cómo funciona la configuración de remotos?

Un **remoto** es una referencia a un repositorio en otro servidor (como GitHub).

```bash
git remote add origin <URL>       # añadir remoto principal
git remote add upstream <URL>     # añadir repositorio original (para forks)
git remote -v                     # listar remotos
git fetch upstream                # obtener cambios del original
git merge upstream/main           # integrar cambios del original
```

- **`origin`**: nombre convencional para el fork propio.
- **`upstream`**: nombre convencional para el repositorio original del que se hizo fork.

---

## 14. ¿Cómo inspeccionar el historial de commits?

```bash
git log                          # historial completo
git log --oneline --graph        # historial resumido con gráfico de ramas
git log --author="Nombre"        # filtrar por autor
git diff                         # diferencias en working directory
git diff --staged                # diferencias en staging
git diff <hash1> <hash2>         # diferencias entre dos commits
git show <hash>                  # detalles de un commit específico
```

---

> **Recursos recomendados:**
> - [Pro Git Book](https://git-scm.com/book/es/v2)
> - [GitHub Docs](https://docs.github.com)
